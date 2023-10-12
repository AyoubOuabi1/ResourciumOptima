package com.ayoub.resourciumoptima.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table( name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;


    @Column(name = "username")
    @Getter
    @Setter
    private String username;

    @Column(name = "email")
    @Getter
    @Setter
    private String email;
    @Column(name = "position")
    @Getter
    @Setter
    private String position;


    @ManyToOne
    @JoinColumn(name = "department_id")
    @Getter
    @Setter
    private Department department;

    @OneToMany(mappedBy = "assignedEmployee", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Task> tasks;
}
