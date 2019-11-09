package com.myvlog.service.impl;

import com.myvlog.dao.UserDao;
import com.myvlog.domian.UserDto;
import com.myvlog.entity.User;
import com.myvlog.factory.DaoFactory;
import com.myvlog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private static Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);

  @Override
    public Map<String, Object> signIn(UserDto userDto) {
        User user = null;
        Map<String, Object> map = new HashMap<>();
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if (user != null) {
            if (user.getPassword().equals(userDto.getPassword())) {
                map.put("msg", "登录成功");
                map.put("data", user);
            } else {
                map.put("msg", "密码错误");
            }
        } else {
            map.put("msg", "手机号不存在");
        }
        return map;
    }
}
