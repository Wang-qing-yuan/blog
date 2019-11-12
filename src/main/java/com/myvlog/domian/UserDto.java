package com.myvlog.domian;

import lombok.Data;

/**
 * @Description 用户传输对象
 */

@Data
public class UserDto {
    private String mobile;
    private String password;

    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }
    public UserDto(){

    }
}
