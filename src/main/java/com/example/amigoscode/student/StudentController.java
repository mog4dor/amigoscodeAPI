package com.example.amigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> getStudents() {
        return this.studentService.getStudents();
    }

    @PostMapping("/registration")
    public void registerNewStudent(@RequestBody Student student) {
        this.studentService.addNewStudent(student);
    }
}
