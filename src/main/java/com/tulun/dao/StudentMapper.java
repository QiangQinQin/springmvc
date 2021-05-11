package com.tulun.dao;

import com.tulun.bean.Student;

import javax.annotation.Resource;
import java.util.List;

public interface StudentMapper {

    public List<Student>  findAll();
    public Student selectStudentById(Integer id);
}
