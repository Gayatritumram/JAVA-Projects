package com.example.girlshostel.controller;

import com.example.girlshostel.model.Student;
import com.example.girlshostel.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private HostelService hostelService;

    // API to add student to a hostel
    @PostMapping("/{formNumber}")
    public ResponseEntity<Student> addStudentToHostel(@PathVariable String formNumber, @RequestBody Student student) {
        hostelService.addStudentToHostel(formNumber, student);
        return ResponseEntity.ok(student);  // Returning student details after being added
    }
}
