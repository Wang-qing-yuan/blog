package com.myvlog.dao;

import com.myvlog.factory.DaoFactory;
import com.myvlog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class BookDaoTest {
    private static Logger logger = LoggerFactory.getLogger(BookDaoTest.class);
    private BookDao bookDao = DaoFactory.getBookDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result = bookDao.batchInsert(JSoupSpider.getBooks());
            if(result.length !=0){
                logger.info("成功新增"+result.length+"本书");
            }
        } catch (SQLException e) {
           logger.error("异常");


        }
    }
}