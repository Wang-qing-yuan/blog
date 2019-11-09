package com.myvlog.service;

import com.myvlog.domian.UserDto;

import java.util.Map;

public interface UserService {
    /**
     * 用户登录功能
     * @param userDto
     * @return
     */
    Map<String,Object> signIn(UserDto userDto);
}
