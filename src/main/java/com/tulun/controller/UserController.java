package com.tulun.controller;

import com.tulun.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller //交给容器管理,所以是由Spring而不是SpringMVC提供的
//在类上添加该注解的URL，称之为根路径，访问的完全路径：根路径+子路径
@RequestMapping("/user")
public class UserController {

    //验证服务有没有正常请求到后端
    @RequestMapping("/test")
    public @ResponseBody String test(){//返回json数据
        return "hello world";//纯测试，不用写业务逻辑
    }

  //即执行器（不同URL对应的执行器不一样）
    // @RequestMapping("userList.do")
    @RequestMapping("userList") //绑定的URL  浏览器输入http://localhost:8080/userList(注意大小写) ，即指向后端，然后他就会找本页31行代码中的jsp
    public ModelAndView userList(){
    //返回用户列表（伪代码：没有从数据库拿，自己new数据）
        ArrayList<User> users = new ArrayList<>();
        User tulun = new User(1, "张三");
        User java = new User(2, "李四");
        User python = new User(3, "王五");

        users.add(tulun);
        users.add(java);
        users.add(python);

        //封装成ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("users",users);
        //封装逻辑视图名(以webapp为根目录)   返回给用户一个页面显示
//        modelAndView.setViewName("/WEB-INF/jsp/UserList.jsp");//WEB-INF
        modelAndView.setViewName("UserList");//在spring-mvc已经配置过jsp页面的前缀后缀，直接写名字就行，会自动拼接
        return  modelAndView;
    }

    //怎么返回图片？？？？？

    @RequestMapping("test1") //绑定的URL
    public ModelAndView test1(){
        //返回用户列表（伪代码：没有从数据库拿，自己new数据）
        ArrayList<User> users = new ArrayList<>();
        User tulun = new User(1, "张三");
        User java = new User(2, "李四");
        User python = new User(3, "王五");

        users.add(tulun);
        users.add(java);
        users.add(python);

        //封装成ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        //封装数据
        modelAndView.addObject("users",users);
        //封装逻辑视图名(以webapp为根目录)   返回给用户一个页面显示
//        modelAndView.setViewName("/WEB-INF/jsp/test1.jsp");//前缀也是/WEB-INF/jsp/ ，可以简化，需要在resources/spring-mvc.xml文件里设置
        modelAndView.setViewName("test1");
        //test1虽然收到了数据，但是并没有设置展示的表格，
        return  modelAndView;
    }
}
