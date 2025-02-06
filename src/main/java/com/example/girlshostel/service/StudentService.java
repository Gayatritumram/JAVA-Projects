package com.example.girlshostel.service;

import com.example.girlshostel.model.Student;

import java.util.List;

public interface StudentService {



    // Method to save student by a specific hostel form number (adds the student to the hostel)
    Student saveStudentByFormNumber(String formNumber, Student student);

    // Method to retrieve a list of all students
    List<Student> getAllStudents();

    // Method to retrieve a student by their ID
    Student getStudentById(Integer id);

    // Method to update an existing student's details by ID
    Student updateStudent(Integer id, Student student);

    // Method to delete a student by their ID
    void deleteStudent(Integer id);
}
