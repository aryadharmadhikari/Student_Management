package com.example.student_app.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @NotNull(message = "ID is required")
    private Long id;

    @NotBlank(message = "Roll number is required")
    private String rollNo;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    private String collegeName;

    private String department;

    // This is the fix. We are telling JPA to name the column "student_year"
    // in the database, which avoids the conflict with the reserved SQL keyword.
    @Column(name = "student_year")
    private Integer year;

    private Double gpa;

    private Double latitude;

    private Double longitude;
}
