package com.attendance.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private String rollNo;
    private String studentName;
    private String mobile;
    private String email;
    private String dob;
    private String address;
    private String city;
    private String pincode;
    private byte[] photo;
    private String user;
    private String standard;
    private String division;
}
