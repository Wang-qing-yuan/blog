package com.myvlog.factory;

import com.myvlog.dao.impl.StudentServiceImpl;
import com.myvlog.service.StudentService;
import com.myvlog.service.UserService;
import com.myvlog.service.impl.UserServiceImpl;

public class ServiceFactory {
    public static StudentService getStudentServiceInstance(){
        return new StudentServiceImpl();
    }
    public static UserService getUserServiceInstance(){
        return new UserServiceImpl();
    }
}
