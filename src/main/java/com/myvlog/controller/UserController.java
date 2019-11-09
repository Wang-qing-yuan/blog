package com.myvlog.controller;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.myvlog.domian.UserDto;
import com.myvlog.factory.ServiceFactory;
import com.myvlog.service.UserService;
import com.myvlog.util.Message;
import com.myvlog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description 用户控制器
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/sign-in")
public class UserController extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("登录用户信息：" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        Map<String, Object> map = userService.signIn(userDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        switch (msg) {
            case Message.SIGN_IN_SUCCESS:
                ro = ResponseObject.success(200, msg, map.get("data"));
                break;
            case Message.PASSWORD_ERROR:
            case Message.MOBILE_NOT_FOUND:
            default:
                ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}