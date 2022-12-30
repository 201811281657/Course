package com.course.business.controller.admin;

import com.course.server.domain.Student;
import com.course.server.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    private static final Logger log = LoggerFactory.getLogger(StudentController.class);
    @RequestMapping("/list")
    public List<Student> list(){
        List<Student> studentList = studentService.list();
        log.info("学生信息{}",studentList);
        return studentList;
    }



}
