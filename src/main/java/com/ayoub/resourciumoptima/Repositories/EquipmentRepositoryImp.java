package com.ayoub.resourciumoptima.Repositories;

import com.ayoub.resourciumoptima.Config.EntityManagerFct;
import com.ayoub.resourciumoptima.entities.Equipment;
import com.ayoub.resourciumoptima.entities.Task;
import com.ayoub.resourciumoptima.interfaces.EquipmentRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EquipmentRepositoryImp implements EquipmentRepository {
    private EntityManager entityManager;


    public EquipmentRepositoryImp() {
        entityManager = EntityManagerFct.getEntityManager();
    }
    @Override
    public void save(Equipment obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public void delete(Long id) {
        Equipment de = findById(id);
        if (de != null){
            entityManager.getTransaction().begin();
            entityManager.remove(de);
            //entityManager.flush();
            entityManager.getTransaction().commit();

        }

    }

    @Override
    public void update(Equipment obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.flush();
        entityManager.getTransaction().commit();

    }

    @Override
    public Equipment findById(Long id) {
        return entityManager.find(Equipment.class, id);
    }

    @Override
    public List<Equipment> getAll() {
        return entityManager.createQuery("SELECT e FROM Equipment e", Equipment.class).getResultList();
    }
}
