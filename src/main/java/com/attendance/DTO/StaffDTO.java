package com.attendance.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StaffDTO {
    private int id;
    private String staffName;
    private String mobile;
    private String qualification;
    private String address;
    private String city;
    private String pincode;
    private String gender;
    private byte[] photo;
    private String user;
    private String standard;
}
