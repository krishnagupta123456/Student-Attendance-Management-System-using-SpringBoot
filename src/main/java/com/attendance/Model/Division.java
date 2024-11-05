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
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String divName;
    private String seat;
    @ManyToOne
    private Standard standard;

    @OneToOne(mappedBy = "division",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private StudentProfile studentProfile;
}
