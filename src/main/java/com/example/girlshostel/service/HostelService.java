package com.example.girlshostel.service;

import com.example.girlshostel.model.Hostel;
import com.example.girlshostel.model.Student;

public interface HostelService {

    Hostel addStudentToHostel(String formNumber, Student student);

    Hostel getHostelDetailsByFormNumber(String formNumber);

    Hostel createHostelWithFormNumber();
}
