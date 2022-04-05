package com.est.studentapp.controller;

import com.est.studentapp.entity.Student;
import com.est.studentapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public void addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent(@RequestBody  Student student){
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudentbyId/{id}")
    public Student getbyID(@PathVariable  Long id){
        return studentService.getStudentById(id);
    }
    @PutMapping("/updateStudent/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){
        studentService.updateStudent(student);
    }
    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
    }
}