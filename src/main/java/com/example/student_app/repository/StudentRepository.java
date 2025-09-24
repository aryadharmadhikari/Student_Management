package com.example.student_app.repository;

import com.example.student_app.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    // Spring Data JPA will automatically provide methods like:
    // save(), findById(), findAll(), deleteById(), etc.
    // You can also define custom query methods here if needed.
}

