package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.interfaces.RepositoryDbInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class DepartmentRepository implements RepositoryDbInterface<Department> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Department obj) {
        entityManager.persist(obj);
    }

    @Override
    public void delete(Long id) {
        Department de = findById(id);
        if (de != null){
            entityManager.remove(de);
        }

    }

    @Override
    public void update(Department obj) {
        entityManager.merge(obj);
    }

    @Override
    public Department findById(Long id) {
        return entityManager.find(Department.class, id);
    }

    @Override
    public List<Department> getAll() {
        return entityManager.createQuery("SELECT e FROM Department e", Department.class).getResultList();
    }
}
