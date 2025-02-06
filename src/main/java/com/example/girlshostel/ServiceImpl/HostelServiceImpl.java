package com.example.girlshostel.service.impl;

import com.example.girlshostel.model.Hostel;
import com.example.girlshostel.model.Student;
import com.example.girlshostel.repository.HostelRepository;
import com.example.girlshostel.repository.StudentRepository;
import com.example.girlshostel.service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
public class HostelServiceImpl implements HostelService {

    @Autowired
    private HostelRepository hostelRepository;

    @Autowired
    private StudentRepository studentRepository;




    // Helper method to generate a unique formNumber
    private String generateFormNumber() {
        // Create a random 5-digit number or you can make it more complex
        Random random = new Random();
        int randomNum = 10000 + random.nextInt(90000);  // Random number between 10000 and 99999
        return "H" + randomNum;
    }

    @Override
    public Hostel addStudentToHostel(String formNumber, Student student) {
        // Find the hostel by formNumber
        Hostel hostel = hostelRepository.findByFormNumber(formNumber)
                .orElseThrow(() -> new RuntimeException("Hostel with form number " + formNumber + " not found"));

        // Set the student to the hostel (bidirectional relationship)
        student.setHostel(hostel);

        // Save the student to the database
        studentRepository.save(student);

        // Assign the student to the hostel and save the hostel
        hostel.setStudent(student);
        return hostelRepository.save(hostel);  // Save the hostel with updated student
    }

    @Override
    public Hostel getHostelDetailsByFormNumber(String formNumber) {
        // Find and return the hostel with its associated student based on formNumber
        return hostelRepository.findByFormNumber(formNumber)
                .orElseThrow(() -> new RuntimeException("Hostel with form number " + formNumber + " not found"));
    }

    @Override
    public Hostel createHostelWithFormNumber() {
        Hostel hostel = new Hostel();
        hostel.setFormNumber(generateFormNumber());  // Set the generated form number
        hostel.setDate(LocalDate.now());  // Set the current date or any other field

        return hostelRepository.save(hostel);
    }
}
