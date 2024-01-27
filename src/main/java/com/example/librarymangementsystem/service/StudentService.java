package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.entities.Student;
import com.example.librarymangementsystem.repository.StudentRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public String addStudent(Student student){
        Student newStudent1=studentRepository.save(student);
        return "Student has been added to db with student id: "+newStudent1.getStudentId();
    }

    public Student findStudentById(Integer id) throws Exception{
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if (optionalStudent.isEmpty()){
            throw new Exception("Invalid student id");
        }
        Student student=optionalStudent.get();
        return student;
    }

}
