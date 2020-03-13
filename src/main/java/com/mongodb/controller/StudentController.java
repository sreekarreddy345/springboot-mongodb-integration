package com.mongodb.controller;


import com.mongodb.model.students;
import com.mongodb.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(value = "/getallstudents")
    public List<students> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/{firstname}")
    public students getByFirstName(@PathVariable("firstname") String firstname) {
        return studentRepository.findByFirstName(firstname);

    }

    @PostMapping(value = "/createstudent")
    public students createStudent(@Valid @RequestBody students student) {
        student.setId(ObjectId.get());
        studentRepository.save(student);
        return student;
    }
}
