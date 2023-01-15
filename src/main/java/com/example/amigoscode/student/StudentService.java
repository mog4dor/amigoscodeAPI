package com.example.amigoscode.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =  this.studentRepository.findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }
        this.studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = this.studentRepository.existsById(studentId);
        if(!exists) {
            throw new IllegalStateException("Student with id : " + studentId + " does not exists");
        }
        this.studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String email, String name) {
        Student studentToUpdate = this.studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(("student with id : " + studentId + " does nor exists")));

        if(email!=null && email.length() > 0 && email.contains("@") && !Objects.equals(studentToUpdate.getEmail(), email)) {
            Optional<Student> studentOptional =  this.studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()) {
                throw new IllegalStateException("Email already taken");
            }
            studentToUpdate.setEmail(email);
        }
        if(name!=null && name.length() > 0 && !Objects.equals(studentToUpdate.getName(), name)) {
            studentToUpdate.setName(name);
        }
    }
}
