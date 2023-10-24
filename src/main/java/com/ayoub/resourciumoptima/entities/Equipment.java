package com.ayoub.resourciumoptima.entities;


import jakarta.enterprise.concurrent.Trigger;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipement") @NoArgsConstructor @AllArgsConstructor
public class Equipment {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Getter
    @Setter
    private String type;


    @Column(name = "purchaseDate")
    @Getter
    @Setter
    private Date purchaseDate;


    @Column(name = "status")
    @Getter
    @Setter
    private String status;



    @Column(name = "maintenance_date")
    @Getter
    @Setter
    private Date maintenance_date;


    @OneToMany(mappedBy = "assignedEquipment", cascade = CascadeType.ALL ,fetch= FetchType.EAGER)
    @Getter
    @Setter
    private List<Task> tasks;

}
