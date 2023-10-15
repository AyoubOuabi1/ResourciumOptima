package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.interfaces.RepositoryDbInterface;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class EmployeeRepository implements RepositoryDbInterface<Employee> {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void save(Employee obj) {
        entityManager.persist(obj);
    }

    @Override
    public void delete(Long id) {
        Employee employe = findById(id);
        if (employe != null) {
            entityManager.remove(employe);
        }
    }

    @Override
    public void update(Employee obj) {
        entityManager.merge(obj);
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> getAll() {
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();

    }

    public Employee findByEmailAndPassword(  String email,String password ) {
        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e WHERE e.email = :email AND e.password = :password", Employee.class)
                .setParameter("email", email)
                .setParameter("password", password)
                .getResultList();
        if (employees.size() > 0) {
            return employees.get(0);
        }
        return null;
    }

}
