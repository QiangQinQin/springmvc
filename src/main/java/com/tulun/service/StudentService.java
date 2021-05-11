package com.tulun.service;

import com.tulun.bean.Student;
import com.tulun.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service //业务处理   表示把当前类交给容器管理
public class StudentService {
    //将dao层的实例 注入到service层中
    @Autowired
    private StudentMapper studentMapper;

    //@Transactional //事务注解
    public List<Student> selectAllStudents(){
        return studentMapper.findAll();//参数合法性检查
    }

    public Student selectStudentById(Integer id){
        if(id<0)
            return  new Student();// 返回一个空对象     //bean里需要提供无参构造方法
        Student student=studentMapper.selectStudentById(id);
        return student;
    }
}
