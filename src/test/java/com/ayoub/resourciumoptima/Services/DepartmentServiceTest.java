package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Department;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentServiceTest {

    static DepartmentService  departmentService;
    @BeforeAll
    static void init() {
        EntityManagerFct.getEntityManagerFactory();
        departmentService= new DepartmentService();
    }
    @Test
    void findDepartment() {
        Department department = departmentService.findDepartment(2L);
        assertNotNull(department);
    }

    @Test
    void saveDepartment() {
        int sizeBefore=departmentService.getDepartments().get().size();
        Department department= new Department();
        department.setName("Department test");
        departmentService.saveDepartment(department);
        int sizeAfter=departmentService.getDepartments().get().size();
        assertEquals(sizeAfter, sizeBefore + 1);

    }

    @Test
    void removeDepartment() throws Exception {
        departmentService.removeDepartment(102L);
        Department department = departmentService.findDepartment(102L);
        assertNull(department);
    }

    @Test
    void updateDepartment() throws Exception {
        Department department = departmentService.findDepartment(2L);
        String departmentName = department.getName();
        department.setName("after update");
        departmentService.updateDepartment(department);
        assertNotEquals(departmentName, department.getName());
    }

    @Test
    void getDepartments() {
        int size=departmentService.getDepartments().get().size();
        assertTrue(size>0);
    }
}