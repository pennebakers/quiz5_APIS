package com.quiz.quiz.controllers;

import com.quiz.quiz.model.Student;
import com.quiz.quiz.repositories.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public Student showOneStudent(@PathVariable("id") int id){
        return studentRepository.findById(id).get();
    }

    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student){
        return studentRepository.save(student);
    }

    @PutMapping("/updateStudent/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id){
        Student newStudent = this.studentRepository.findById(id).get();
        newStudent.setFirstName(student.getFirstName());
        newStudent.setLastName(student.getLastName());
        newStudent.setEmail(student.getEmail());
        return this.studentRepository.save(newStudent);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public void deleteStudent(@PathVariable("id") int id){
        studentRepository.deleteById(id);
    }
}
