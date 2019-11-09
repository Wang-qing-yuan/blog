package com.myvlog.dao;

import com.myvlog.entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface  StudentDao {
    int insert(Student student) throws SQLException;

    /**
     *
     * @param studentList
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<Student> studentList) throws SQLException;

    /**
     * 查询所有学生
     * @return
     * @throws SQLException
     */
    List<Student> selectAll() throws SQLException;
}

