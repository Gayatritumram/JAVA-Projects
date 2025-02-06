package com.example.girlshostel.controller;

import com.example.girlshostel.model.Hostel;
import com.example.girlshostel.model.Student;
import com.example.girlshostel.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HostelController {

    @Autowired
    private HostelService hostelService;

    // API to create a hostel with a generated formNumber
    @PostMapping("/createHostel")
    public ResponseEntity<Hostel> createHostel() {
        Hostel newHostel = hostelService.createHostelWithFormNumber();
        return ResponseEntity.ok(newHostel);
    }

    // API to get hostel and student details by formNumber
    @GetMapping("/getHostelDetailsByFormNumber/{formNumber}")
    public ResponseEntity<Hostel> getHostelDetailsByFormNumber(@PathVariable String formNumber) {
        Hostel hostel = hostelService.getHostelDetailsByFormNumber(formNumber);
        return ResponseEntity.ok(hostel);
    }

    // API to add student to hostel
    @PostMapping("/addStudentToHostel/{formNumber}")
    public ResponseEntity<Hostel> addStudentToHostel(@PathVariable String formNumber, @RequestBody Student student) {
        Hostel updatedHostel = hostelService.addStudentToHostel(formNumber, student);
        return ResponseEntity.ok(updatedHostel);
    }
}
