package dataaccess.DAO;

import dataaccess.DTO.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class LocationDAO extends DAO<Location> {

    @Override
    public Location findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Location location = entityManager.find(Location.class, id);
        entityManager.close();
        return location;
    }

    @Override
    public List<Location> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Location> locations = entityManager.createQuery("from Location", Location.class).getResultList();
        entityManager.close();
        return locations;
    }

    @Override
    public Location create(EntityManagerFactory entityManagerFactory, Location object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        entityManager.close();
        return entityManager.find(Location.class, object.getIdLocation());
    }

    @Override
    public Location update(EntityManagerFactory entityManagerFactory, int id, Location object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Location toUpdateLocation = entityManager.find(Location.class, id);
        toUpdateLocation.setRegion(object.getRegion());
        toUpdateLocation.setDepartment(object.getDepartment());
        entityManager.persist(toUpdateLocation);
        transaction.commit();
        object = entityManager.find(Location.class, toUpdateLocation.getIdLocation());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Location object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Location toDelete = entityManager.find(Location.class, object.getIdLocation());
        System.out.println(toDelete);
        entityManager.remove(toDelete);
        transaction.commit();
        entityManager.close();
    }
}
