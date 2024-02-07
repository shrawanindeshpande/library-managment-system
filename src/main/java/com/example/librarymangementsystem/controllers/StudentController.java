package com.example.librarymangementsystem.controllers;

import com.example.librarymangementsystem.entities.Student;
import com.example.librarymangementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/findStudentById")
    public ResponseEntity findById(@RequestParam("studentId") Integer studentId) {
        Student student;
        try {
            student = studentService.findStudentById(studentId);
            return new ResponseEntity<>(student,HttpStatus.OK );
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/deleteStudent")
    public ResponseEntity deleteStudent(@RequestParam("studentId") int studentId){
        try{
            String result=studentService.deleteStudent(studentId);
            return new ResponseEntity<>(result,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

}
