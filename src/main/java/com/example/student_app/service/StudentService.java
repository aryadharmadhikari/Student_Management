package com.example.student_app.service;

import com.example.student_app.model.Student;
import com.example.student_app.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id));
    }

    public Student createStudent(Student student) {
        if (student.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Student ID cannot be null");
        }
        if (studentRepository.existsById(student.getId())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Student with ID " + student.getId() + " already exists.");
        }
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student existingStudent = getStudentById(id);

        // Update all fields from the provided details
        existingStudent.setRollNo(studentDetails.getRollNo());
        existingStudent.setFirstName(studentDetails.getFirstName());
        existingStudent.setLastName(studentDetails.getLastName());
        existingStudent.setEmail(studentDetails.getEmail());
        existingStudent.setCollegeName(studentDetails.getCollegeName());
        existingStudent.setDepartment(studentDetails.getDepartment());
        existingStudent.setYear(studentDetails.getYear());
        existingStudent.setGpa(studentDetails.getGpa());
        existingStudent.setLatitude(studentDetails.getLatitude());
        existingStudent.setLongitude(studentDetails.getLongitude());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
