package com.myvlog.dao;

import com.myvlog.entity.Student;
import com.myvlog.util.JSoupSpiderr;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static com.myvlog.factory.DaoFactory.getStudentDaoInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentDaoTest {

    @Test
    public void insert() throws SQLException {
        Student student = new Student();
        student.setId(1);
        student.setAvatar("135");
        student.setUsername("wqy");
        student.setCreateTime(LocalDateTime.now());
        System.out.println(getStudentDaoInstance().insert(student));



    }
    @Test
    public void batchInsert() throws SQLException{
        int[] n = getStudentDaoInstance().batchInsert(JSoupSpiderr.getStudent());
        assertEquals(24,n.length);
    }

//    @Test
//    public void selectAll() throws SQLException{
//        List<Student> studentList = StudentDaoInstance().selectAll();
//        studentList.forEach(System.out::println);
//    }

}