package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    static EmployeeService  employeeService;
    @BeforeAll
    static void init() {
        EntityManagerFct.getEntityManagerFactory();
        employeeService= new EmployeeService();

    }

    @Test
    void findEmployee() {
        Employee employee = employeeService.findEmployee(2L);
        assertNotNull(employee);
      //  assertEquals("ayoub@gmail.com", employee.getEmail());
    }

    @Test
    void saveEmployee() {
        DepartmentService departmentService = new DepartmentService();
        int sizeBefore=employeeService.getEmployees(null).get().size();
        Department department= departmentService.findDepartment(2L);
        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setPosition("admin");
        employee.setFirstName("mohamed");
        employee.setLastName("ouabi");
        employee.setEmail("mohamed@gmail.com");
        employee.setPassword("password");
        employeeService.saveEmployee(employee);
        int sizeAfter=employeeService.getEmployees(null).get().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    void removeEmployee() throws Exception {
        employeeService.removeEmployee(202L);
        Employee employee =employeeService.findEmployee(202L);
        assertNull(employee);
    }

    @Test
    void updateEmployee() throws Exception {
        Employee employee = employeeService.findEmployee(2L);
        String lastname=employee.getLastName();
        employee.setLastName("test");
        employeeService.updateEmployee(employee);
        assertNotEquals(lastname, employee.getLastName());
    }

    @Test
    void getEmployees() {
        int s=employeeService.getEmployees(null).get().size();
        assertTrue(s>0);
    }

    @Test
    void checkLogin() {
        Employee employee = employeeService.checkLogin("ayoub@gmail.com","ayoub");
        assertNotNull(employee);
    }

    @Test
    void logOut() {
    }
}