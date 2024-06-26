package com.ic.dinin.infrastructure;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class JpaHelper {

    private final EntityManagerFactory emf;

    public JpaHelper(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void doTransaction(JpaCallbackVoid callback){
        try(EntityManager em = emf.createEntityManager()){
            em.getTransaction().begin();
            callback.execute(em);
            em.getTransaction().commit();
        }
    }
    public <T> T doTransaction(JpaCallback<T> callback) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            T result = callback.execute(em);
            em.getTransaction().commit();
            return result;
        }

    }

    public void doManaged(JpaCallbackVoid callback){
        try(EntityManager em = emf.createEntityManager()){
            callback.execute(em);
        }
    }

    public <T> T doManaged(JpaCallback<T> callback) {
        try (EntityManager em = emf.createEntityManager()) {
            return callback.execute(em);
        }
    }

}
