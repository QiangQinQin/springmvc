package com.tulun.controller;

import com.tulun.bean.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;//注意是接口，不是注解，不要引错包

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * 基于 非注解 实现Handler * 必须实现Controller接口
 * 基于配置形式是，一个Controller实现类 UserController1只能针对特定的一个URL(/userList1)做处理
 */
public class UserController1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //返回用户列表
        ArrayList<User> users = new ArrayList<>();
        User tulun = new User(1, "tulun");
        User java = new User(2, "java");
        User user = new User(3, "211");
        users.add(tulun);
        users.add(java);
        users.add(user);
        //返回ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("UserList");//自动补全为jsp页面名
        return modelAndView;
    }
}
