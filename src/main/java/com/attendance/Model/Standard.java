package com.attendance.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String stdName;

    @OneToOne(mappedBy = "standard",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private StaffProfile staffProfile;

    @OneToOne(mappedBy = "standard",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private StudentProfile studentProfile;
}
