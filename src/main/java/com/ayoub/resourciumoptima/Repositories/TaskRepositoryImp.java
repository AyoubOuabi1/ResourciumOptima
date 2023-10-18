package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Department;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.DepartmentRepository;
import com.ayoub.resourciumoptima.interfaces.TaskRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TaskRepositoryImp implements TaskRepository {
    private EntityManager entityManager;


    public TaskRepositoryImp() {
        entityManager = EntityManagerFct.getEntityManager();
    }
    @Override
    public void save(Task obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(Long id) {
        Task de = findById(id);
        if (de != null){
            entityManager.getTransaction().begin();
            entityManager.remove(de);
            //entityManager.flush();
            entityManager.getTransaction().commit();

        }

    }

    @Override
    public void update(Task obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public Task findById(Long id) {
        return entityManager.find(Task.class, id);
    }

    @Override
    public List<Task> getAll() {
        return entityManager.createQuery("SELECT e FROM Task e", Task.class).getResultList();
    }
}
