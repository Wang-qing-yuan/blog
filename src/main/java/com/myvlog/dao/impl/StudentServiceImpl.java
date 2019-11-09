package com.myvlog.dao.impl;

import com.myvlog.dao.StudentDao;
import com.myvlog.factory.DaoFactory;
import com.myvlog.service.StudentService;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = DaoFactory.getStudentDaoInstance();

//    @Override
//    public List<Student> listStudents(){
//        List<Student>studentList = null;
//        try{
//            studentList = studentDao.selectAll();
//        }catch (SQLException e){
//            System.out.println("查询所有学生出现异常");
//        }
//        return studentList;
//    }
}
