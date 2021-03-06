package com.myvlog.factory;

import com.myvlog.dao.BookDao;
import com.myvlog.dao.StudentDao;
import com.myvlog.dao.UserDao;
import com.myvlog.dao.impl.BookDaoImpl;
import com.myvlog.dao.impl.StudentDaoImpl;
import com.myvlog.dao.impl.UserDaoImpl;

public class DaoFactory {
    public static StudentDao getStudentDaoInstance(){
        return new StudentDaoImpl();
    }
    public static UserDao getUserDaoInstance(){
        return new UserDaoImpl();
    }
    public static BookDao getBookDaoInstance(){
        return new BookDaoImpl();
    }

}
