package com.myvlog.dao.impl;

import com.myvlog.dao.BookDao;
import com.myvlog.entity.Book;
import com.myvlog.util.DbUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
public class BookDaoImpl implements BookDao {
    private static Logger logger = LoggerFactory.getLogger(BookDaoImpl.class);

    @Override
    public int[] batchInsert(List<Book> bookList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_book (title,content,cover,diamond,nickname,comments,likes,publish_time) VALUES(?,?,?,?,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        bookList.forEach(book -> {
            try {
                pstmt.setString(1, book.getTitle());
                pstmt.setString(2, book.getContent());
                pstmt.setString(3, book.getCover());
                pstmt.setInt(4, book.getDiamond());
                pstmt.setString(5, book.getNickname());
                pstmt.setInt(6, book.getComments());
                pstmt.setInt(7, book.getLikes());
                pstmt.setObject(8, book.getPublishTime());
                pstmt.addBatch();
            } catch (SQLException e) {
                logger.error("批量导入文章信出错");
            }
        });
        int[] result = pstmt.executeBatch();
        connection.commit();
        DbUtil.close(null, pstmt, connection);
        return result;
    }
}



