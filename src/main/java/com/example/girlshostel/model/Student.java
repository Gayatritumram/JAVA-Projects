package com.example.girlshostel.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String fullName;
    private String birthDate;
    private int age;
    private String gender;
    private String maritalStatus;
    private String bloodGroup;
    private String religion;
    private String date;


    @OneToOne(mappedBy = "student")
    @JsonBackReference
    private Hostel hostel;



}
