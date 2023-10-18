package com.ayoub.resourciumoptima.Config;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EntityManagerFct {
    private static EntityManagerFactory entityManagerFactory ;
   private static EntityManager entityManager;

    public static EntityManagerFactory getEntityManagerFactory() {
         if (entityManagerFactory!=null) {
             return entityManagerFactory;
         }else {
             entityManagerFactory = Persistence.createEntityManagerFactory("default");
             return entityManagerFactory;
         }
    }

    public static EntityManager getEntityManager() {
        if (entityManager!=null){
            return entityManager;
        }else {
            entityManager = getEntityManagerFactory().createEntityManager();
            return entityManager;
        }

    }
}
