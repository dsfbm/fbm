package com.example.demo_01.dao.impi;

import com.example.demo_01.Entity.Student;
import com.example.demo_01.dao.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}

