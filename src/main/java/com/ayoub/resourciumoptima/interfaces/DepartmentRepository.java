package com.ayoub.resourciumoptima.interfaces;

import com.ayoub.resourciumoptima.entities.Department;

import java.util.List;

public interface DepartmentRepository {


    void save(Department obj);

    void delete(Long id);

    void update(Department obj);

    Department findById(Long id);

    List<Department> getAll();
}
