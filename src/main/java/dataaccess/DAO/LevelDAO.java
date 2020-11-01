package dataaccess.DAO;

import dataaccess.DTO.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class LevelDAO extends DAO<Level> {

    @Override
    public Level findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Level level = entityManager.find(Level.class, id);
        entityManager.close();
        return level;
    }

    @Override
    public Level create(EntityManagerFactory entityManagerFactory, Level object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        object = entityManager.find(Level.class, object.getIdLevel());
        entityManager.close();
        return object;
    }

    @Override
    public Level update(EntityManagerFactory entityManagerFactory, int id, Level object) {
        return null;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Level object) {

    }
}
