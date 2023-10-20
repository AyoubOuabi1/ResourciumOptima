package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
 import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class DepartmentRepositoryImp implements DepartmentRepository {
    private EntityManager entityManager;


    public DepartmentRepositoryImp () {
        entityManager = EntityManagerFct.getEntityManager();
    }
    @Override
    public void save(Department obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(Long id) {
        Department de = findById(id);
        if (de != null){
            entityManager.getTransaction().begin();
            entityManager.remove(de);
           // entityManager.flush();
            entityManager.getTransaction().commit();

        }

    }

    @Override
    public void update(Department obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

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
