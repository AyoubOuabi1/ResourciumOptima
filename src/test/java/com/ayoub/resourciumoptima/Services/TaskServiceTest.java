package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.entities.Task;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    static TaskService  taskService;
    @BeforeAll
    static void init() {
        EntityManagerFct.getEntityManagerFactory();
        taskService= new TaskService();
    }

    @Test
    void findTask() {
        Task task= taskService.findTask(7L);
        assertNotNull(task);
    }

    @Test
    void saveTask() throws Exception {
        EmployeeService employeeService= new EmployeeService();
        EquipmentService equipmentService= new EquipmentService();
        Employee employee = employeeService.findEmployee(104L);
        Equipment equipment = equipmentService.findEquipment(52L);
        Task task = new Task();
        task.setAssignedEquipment(equipment);
        task.setAssignedEmployee(employee);
        task.setDescription("test description");
        task.setPriority("high");
        task.setName("test name");
        task.setDueDate(new Date(System.currentTimeMillis()));
        task.setEndDate(new Date(System.currentTimeMillis()));
        task.setStatus("not yet started");
        equipment.setStatus("not available");
        equipmentService.updateEquipment(equipment);
        taskService.saveTask(task);
    }

    @Test
    void removeTask() throws Exception {
        taskService.removeTask(7L);
        Task task= taskService.findTask(7L);
        assertNull(task);
    }

    @Test
    void updateTask() throws Exception {
        Task task= taskService.findTask(8L);
        String name=task.getName();
        task.setName("after update");
        taskService.updateTask(task);
        assertNotEquals(name, task.getName());

    }

    @Test
    void getTasks() {
        int s=taskService.getTasks().get().size();
        assertTrue(s>0);
    }
}