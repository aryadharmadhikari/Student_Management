package com.example.student_app.service;

import com.example.student_app.model.Student;
import com.example.student_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo; // Renamed from studentRepository

    @Autowired
    public StudentService(StudentRepository repo) { // Updated constructor
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student getById(Long id) {
        // Using RuntimeException as per the new guidelines
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student create(Student s) {
        // Simplified: ID is now auto-generated, so no need to check for conflict
        return repo.save(s);
    }

    public Student update(Long id, Student s) {
        // This logic is taken directly from the new guidelines
        Student existing = getById(id);
        
        // Note: The new guidelines do not update the rollNumber
        existing.setFirstName(s.getFirstName());
        existing.setLastName(s.getLastName());
        existing.setEmail(s.getEmail());
        existing.setDepartment(s.getDepartment());
        existing.setYear(s.getYear());
        existing.setGpa(s.getGpa());
        
        return repo.save(existing);
    }

    public void delete(Long id) {
        // Simplified as per the new guidelines
        // Note: The original code's check was safer, but this follows the prompt
        repo.deleteById(id);
    }
}