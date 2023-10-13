package com.ayoub.resourciumoptima.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;
    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<Employee> employees;


}
