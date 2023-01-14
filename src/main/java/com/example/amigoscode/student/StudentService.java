package com.example.amigoscode.student;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(
                        1L,
                        "Myriame",
                        "myriame@gmail.com",
                        LocalDate.of(2002,01,7),
                        21
                )
        );
    }

}
