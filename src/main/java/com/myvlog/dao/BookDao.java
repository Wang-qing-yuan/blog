package com.myvlog.dao;

import com.myvlog.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDao {


    /**
     *新增书籍
     * @param booklist
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<Book> booklist) throws SQLException;


}

