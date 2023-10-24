package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.entities.Task;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class EquipmentServiceTest {

    @Test
    void getEquipments() {
        EquipmentService equipmentService = new EquipmentService();
        Equipment equipment = new Equipment();
        equipment.setMaintenance_date(new Date(System.currentTimeMillis()));
        equipment.setType("jetable");
        equipment.setName("equipment");
        equipment.setPurchaseDate(new Date(System.currentTimeMillis()));
        equipment.setStatus("available");
        equipmentService.saveEquipment(equipment);

        TaskService taskService = new TaskService();

        Task task =new  Task();

        task.setAssignedEquipment(equipment);
        task.setDescription("test description");

        task.setPriority("high");
        task.setEndDate(Date.valueOf("22-12-2024"));
        task.setDueDate(new Date(System.currentTimeMillis()));
        EmployeeService employee=new EmployeeService();
        Long id=104L;
        Employee emp=employee.findEmployee(id);
        task.setAssignedEmployee(emp);
        taskService.saveTask(task);
        taskService.getTasks().forEach(t -> System.out.println(t) );
    }
}