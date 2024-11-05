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
public class StaffProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String staffName;
    private String mobile;
    private String qualification;
    private String address;
    private String city;
    private String pincode;
    private String gender;
    @Lob
    private byte[] photo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "standard_id")
    private Standard standard;



}
