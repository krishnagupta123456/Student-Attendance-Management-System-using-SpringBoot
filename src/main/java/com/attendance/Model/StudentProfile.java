package com.attendance.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String rollNo;
    private String studentName;
    private String mobile;
    private String email;
    private String dob;
    private String address;
    private String city;
    private String pincode;
    @Lob
    private byte[] photo;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id")
    private Standard standard;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "division_id")
    private Division division;


}
