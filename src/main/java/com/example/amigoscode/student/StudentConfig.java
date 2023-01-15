package com.example.amigoscode.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository) {
        return args -> {
            Student myriame = new Student(
                    "Myriame",
                    "myriame@gmail.com",
                    LocalDate.of(2002, 1,7)
            );
            Student adam = new Student(
                    "Adam",
                    "adam@gmail.com",
                    LocalDate.of(2002, 7,25)
            );

            repository.saveAll(
                    List.of(myriame,adam)
            );
        };
    }
}
