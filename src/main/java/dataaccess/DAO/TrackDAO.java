package dataaccess.DAO;

import dataaccess.DTO.Track;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TrackDAO extends DAO<Track> {

    @Override
    public Track findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Track track = entityManager.find(Track.class, id);
        entityManager.close();
        return track;
    }

    @Override
    public List<Track> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Track> tracks = entityManager.createQuery("from Track", Track.class).getResultList();
        entityManager.close();
        return tracks;
    }

    @Override
    public Track create(EntityManagerFactory entityManagerFactory, Track object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        return entityManager.find(Track.class, object.getId());
    }

    @Override
    public Track update(EntityManagerFactory entityManagerFactory, int id, Track object) {
        return null;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Track object) {

    }
}
