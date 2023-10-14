package com.ayoub.resourciumoptima.Services;

import com.ayoub.resourciumoptima.Repositories.DepartmentRepository;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;

import java.util.List;

public class DepartmentService {

    DepartmentRepository departmentRepository;

    public Department findDepartment(Long id) {
        return departmentRepository.findById(id);
    }

    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    public void removeDepartment(Long id) {
        departmentRepository.delete(id);
    }

    public void updateDepartment(Department department) {
        departmentRepository.update(department);
    }

    public List<Department> getDepartments() {
        return departmentRepository.getAll();
    }
}
