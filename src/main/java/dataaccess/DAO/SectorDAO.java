package dataaccess.DAO;

import dataaccess.DTO.Sector;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class SectorDAO extends DAO<Sector> {

    @Override
    public Sector findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Sector sector = entityManager.find(Sector.class, id);
        entityManager.close();
        return sector;
    }

    @Override
    public List<Sector> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Sector> sectors = entityManager.createQuery("from Sector", Sector.class).getResultList();
        entityManager.close();
        return sectors;
    }

    @Override
    public Sector create(EntityManagerFactory entityManagerFactory, Sector object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        entityManager.close();
        return entityManager.find(Sector.class, object.getIdSector());
    }

    @Override
    public Sector update(EntityManagerFactory entityManagerFactory, int id, Sector object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Sector toUpdateSector = entityManager.find(Sector.class, id);
        toUpdateSector.setName(object.getName());
        toUpdateSector.setTracks(object.getTracks());
        entityManager.persist(toUpdateSector);
        transaction.commit();
        object = entityManager.find(Sector.class, toUpdateSector.getIdSector());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Sector object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Sector toDelete = entityManager.find(Sector.class, object.getIdSector());
        System.out.println(toDelete);
        entityManager.remove(toDelete);
        transaction.commit();
        entityManager.close();
    }
}
