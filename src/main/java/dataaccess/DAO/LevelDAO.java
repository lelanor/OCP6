package dataaccess.DAO;

import dataaccess.DTO.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class LevelDAO extends DAO<Level>{

    @Override
    public Level findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Level level = entityManager.find(Level.class, id);
        entityManager.close();
        return level;
    }

    @Override
    public Level create(EntityManagerFactory entityManagerFactory, Level object) {
        return null;
    }

    @Override
    public Level update(EntityManagerFactory entityManagerFactory, Level object) {
        return null;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Level object) {

    }
}
