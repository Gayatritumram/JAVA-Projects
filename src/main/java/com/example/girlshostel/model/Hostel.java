package com.example.girlshostel.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hostelId;

    @Column(nullable = false, unique = true)
    private String formNumber;

    private LocalDate date;

    // One-to-one mapping with Student
    @OneToOne
    @JoinColumn(name = "student_id", referencedColumnName = "studentId", unique = true)
    @JsonManagedReference
    private Student student;

}
