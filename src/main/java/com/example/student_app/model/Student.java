package com.example.student_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Roll number is required")
    @Column(unique = true)
    private String rollNumber; // Renamed from rollNo

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(unique = true) // Added unique constraint
    private String email;

    private String department;

    @Min(1)
    @Max(4)
    @Column(name = "student_year") // This avoids the SQL keyword conflict
    private int year;

    @DecimalMin("0.0")
    @DecimalMax("10.0")
    private double gpa;

    // Removed collegeName, latitude, and longitude
}