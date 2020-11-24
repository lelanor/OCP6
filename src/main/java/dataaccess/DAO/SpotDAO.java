package dataaccess.DAO;

import dataaccess.DTO.Spot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SpotDAO extends DAO<Spot> {

    @Override
    public Spot findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Spot spot = entityManager.find(Spot.class, id);
        entityManager.close();
        return spot;
    }

    @Override
    public List<Spot> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Spot> spots = entityManager.createQuery("from Spot", Spot.class).getResultList();
        entityManager.close();
        return spots;
    }

    @Override
    public Spot create(EntityManagerFactory entityManagerFactory, Spot object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        entityManager.close();
        return entityManager.find(Spot.class, object.getIdSpot());
    }

    @Override
    public Spot update(EntityManagerFactory entityManagerFactory, int id, Spot object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Spot toUpdateSpot = entityManager.find(Spot.class, id);
        toUpdateSpot.setName(object.getName());
        toUpdateSpot.setSectors(object.getSectors());
        entityManager.persist(toUpdateSpot);
        transaction.commit();
        object = entityManager.find(Spot.class, toUpdateSpot.getIdSpot());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Spot object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Spot toDelete = entityManager.find(Spot.class, object.getIdSpot());
        System.out.println(toDelete);
        entityManager.remove(toDelete);
        transaction.commit();
        entityManager.close();
    }
}
