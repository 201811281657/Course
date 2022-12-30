package com.course.server.service;

import com.course.server.domain.Student;
import com.course.server.domain.StudentExample;
import com.course.server.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {
    @Resource
    private StudentMapper studentMapper;

    public List<Student> list(){
        StudentExample studentExample = new StudentExample();
        List<Student> students = studentMapper.selectByExample(studentExample);
        for(int i =0;i<students.size();i++){
//            System.out.println(students.get(i));
        }
        return students;
    }
}
