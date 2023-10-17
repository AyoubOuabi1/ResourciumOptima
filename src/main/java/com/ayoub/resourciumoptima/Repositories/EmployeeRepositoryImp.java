package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.entities.Employee;
import com.ayoub.resourciumoptima.interfaces.EmployeeRepository;
import com.ayoub.resourciumoptima.interfaces.RepositoryDbInterface;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transaction;

import java.util.List;

  public class EmployeeRepositoryImp implements EmployeeRepository {

    private EntityManager entityManager;


    public EmployeeRepositoryImp () {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
         entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Employee obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();
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

    @Override
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
