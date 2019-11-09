package com.myvlog.dao.impl;

import com.myvlog.dao.StudentDao;
import com.myvlog.entity.Student;
import com.myvlog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public int insert(Student student) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_student VALUES (NULL,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, student.getUsername());
        pstmt.setString(2, student.getAvatar());
        pstmt.setTimestamp(3, Timestamp.valueOf(student.getCreateTime()));
        int n = pstmt.executeUpdate();
        connection.commit();
        pstmt.close();
        connection.close();
        return n;
    }
    @Override
    public int[] batchInsert(List<Student> studentList) throws SQLException {
        Connection connection =  DbUtil.getConnection();
        String sql = "INSERT INTO t_student VALUES (NULL,?,?,?,?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.setAutoCommit(false);
        studentList.forEach(student -> {
            try {
                pstmt.setString(1,student.getUsername());
                pstmt.setString(2,student.getAvatar());
                pstmt.setTimestamp(3,Timestamp.valueOf(student.getCreateTime()));
                pstmt.setString(4,student.getDescription());
                pstmt.addBatch();
            } catch (SQLException e) {
                System.out.println("获取失败");
            }

        });

        //执行批处理操作
        int[] result = pstmt.executeBatch();
        //提交
        connection.commit();
        //关闭操作
        pstmt.close();
        connection.close();

        return result;
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        return null;
    }

//    @Override
//    public List<Student> selectAll() throws SQLException{
//        Connection connection=DBUtil.getConnection();
//        String sql = "SELECT*FROM t_student ORDER BY id DESC";
//        preparedStatement pstmt = connection.prepareStatement(sal);
//        ResultSet rs= pstmt.executeQuery();
//        while (re.next()){
//            Student student = new Student();
//            student.setId(re.getInt("id"));
//            student.setUsername(rs.getString("username"));
//            student.setAvatar(rs.getString("avatar"));
//            Timestamp timestamp = rs.getTimestamp("create_time");
//            student.setCreateTime(timestamp.toLocalDateTime());
//
//        }
//        return studentList;
//    }
}
