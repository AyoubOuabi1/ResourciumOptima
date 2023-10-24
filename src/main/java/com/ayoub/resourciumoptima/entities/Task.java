package com.ayoub.resourciumoptima.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    @Getter
    @Setter
    private String description;

     @Column(name = "due_date")
    @Getter
    @Setter
    private Date dueDate;

    @Column(name = "end_date")
    @Getter
    @Setter
    private Date endDate;

    @Column(name = "priority")
    @Getter
    @Setter
    private String priority;

    @Column(name = "status")
    @Getter
    @Setter
    private String status;
    @ManyToOne
    @JoinColumn(name = "assigned_employee_id")
    @Getter
    @Setter
    private Employee assignedEmployee;

    @ManyToOne
    @JoinColumn(name = "assigned_equipment_id")
    @Getter
    @Setter
    private Equipment assignedEquipment;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", endDate=" + endDate +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", assignedEmployee=" + assignedEmployee +
                ", assignedEquipment=" + assignedEquipment +
                '}';
    }
}
