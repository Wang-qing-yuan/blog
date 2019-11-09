package com.myvlog.dao;

import com.myvlog.factory.DaoFactory;
import com.myvlog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void insert() {
    }

    @Test
    public void batchInsert() {
        try{
            int[] result = userDao.batchInsert(JSoupSpider.getUsers());


        }catch (SQLException e){
            logger.error("批量新增用户出现异常");
        }
    }

    @Test
    public void selectAll() {
    }
}