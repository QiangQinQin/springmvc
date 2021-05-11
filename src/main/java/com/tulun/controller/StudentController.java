package com.tulun.controller;

import com.tulun.bean.Student;
import com.tulun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@Controller
//对URL请求进行分类管理，URL访问变为：根路径+子路径（如：/student/list）
@RequestMapping("/student")
public class StudentController {
    @Autowired
//也叫处理器handler（将service层对象注入    匹配URL和方法）
  private StudentService studentService;
//    @RequestMapping("/list",method = RequestMethod.GET) //测试限制HTTP请求方法
    @RequestMapping(value = "/list")
//    @RequestMapping("/studentlist")//浏览器URL   http://localhost:8080/studentlist
    public ModelAndView list(HttpServletRequest request){
        List<Student> students = studentService.selectAllStudents();
        System.out.println("sid： "+request.getParameter("SID"));
        ////在控制台查日志，观察对象获取好了没
//        Iterator<Student> iterator = students.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students",students);//填充数据
        modelAndView.setViewName("StudentList");//jsp页面   填充视图
        return modelAndView;
    }

    @RequestMapping(value = "/list1" )
//    测试用Model参数  返回String的形式传数据
    public String list1(Model model) throws IOException {
        List <Student> students = studentService.selectAllStudents();
        model.addAttribute("students",students);
        return "StudentList";
    }


    @RequestMapping(value = "/{id}") //接受StudentList.jsp传来的数据
    // {id} 是通配符，1 2 3 都行，把匹配到的数据给到id上，然后下面又把id绑定到形参上

    // @PathVariable注解 可以 将注解括号中的属性  绑定到  当前函数紧挨着的的形参上
    // ({id}  类型 得和int id一致)
      public ModelAndView edit(@PathVariable("id")int id) throws Exception {
          Student student = studentService.selectStudentById(id);
          // 修改页面将原数据进行回显
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.addObject("student",student);
          modelAndView.setViewName("editStudent");//jsp页面，前缀后缀在spring-mvc2.xml里配置过了
          return modelAndView;
    }


//    @RequestMapping("/base")//处理浏览器请求 http://localhost:8080/student/base
//    public ModelAndView base(){
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("base");//指向base.jsp
//        return modelAndView;
//    }
//  返回String和上面 返回modelAndView效果一样
    @RequestMapping("/base")
    public String base(){
        return "base";
    }

    @RequestMapping("/test")//base.jsp中form提交的数据到了s这里
//    public void test(int num){
//        System.out.println("test:"+num);
//        //不关心页面报错，只关系日志，看  前端提交数据后端有没有接受到
//    }

    //int number由于和num名不一样，会报错err 500；
    // 改为Integer，err404,和base.jsp里表单提交的名称不一致时会为null；
    public void test(@RequestParam("num")Integer number){//把num绑定到number上
        System.out.println("test:"+number);
        //不关心页面报错，只关心日志，看  前端提交数据后端有没有接受到
    }


    @RequestMapping("/submit")//editStudent.jsp提交过来的
//    public String submit(Student student){
////        把前端提交的数据以自定义对象的类型进行接受
//        System.out.println("submit:"+student);
//        System.out.println("id:"+student.getSID());
////        return "redirect:/student/list";//重定向后的list对应的页面不能通过HttpServletRequest.getParameter拿到 id
//        return "forward:/student/list";//地址仍然为http://localhost:8080/student/submit，但内容是list的
//    }

//    //测试void类型的页面重定向 转发
//    public void submit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        //forward 传了request, response，所以能页面共享          转向"/student/list"
//         request.getRequestDispatcher("/student/list").forward(request, response);
//    }
//
//    public void submit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
//        //redirect
//        response.sendRedirect("/student/list");
//    }
    public void submit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");//除了json，也可以是css html
        response.getWriter().write("hello Tulun");
    }
}