package com.example.librarymangementsystem.controllers;

import com.example.librarymangementsystem.entities.Student;
import com.example.librarymangementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<String>  addStudent(@RequestBody Student student){
        String result=studentService.addStudent(student);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
