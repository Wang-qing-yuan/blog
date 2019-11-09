package com.myvlog.dao;

import com.myvlog.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    int insert(User user) throws SQLException;

    /**
     *新增用户
     * @param userList
     * @return int[]
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList) throws SQLException;

    /**
     * 查询所有用户
     * @return
     * @throws SQLException
     */
    List<User> selectAll() throws SQLException;

    /**
     * 根据手机号查找用户
     * @param mobile
     * @return
     * @throws SQLException
     */
    User findUserByMobile(String mobile) throws SQLException;
}
