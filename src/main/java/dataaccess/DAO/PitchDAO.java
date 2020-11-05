package dataaccess.DAO;

import dataaccess.DTO.Pitch;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class PitchDAO extends DAO<Pitch> {

    @Override
    public Pitch findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Pitch pitch = entityManager.find(Pitch.class, id);
        entityManager.close();
        return pitch;
    }

    @Override
    public List<Pitch> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Pitch> pitches = entityManager.createQuery("from Pitch", Pitch.class).getResultList();
        entityManager.close();
        return pitches;
    }

    @Override
    public Pitch create(EntityManagerFactory entityManagerFactory, Pitch object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        object = entityManager.find(Pitch.class, object.getIdPitch());
        entityManager.close();
        return object;
    }

    @Override
    public Pitch update(EntityManagerFactory entityManagerFactory, int id, Pitch object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Pitch modifiedPitch = entityManager.find(Pitch.class,id);
        modifiedPitch.setDegree(object.getDegree());
        modifiedPitch.setName(object.getName());
        entityManager.persist(modifiedPitch);
        transaction.commit();
        object = entityManager.find(Pitch.class, modifiedPitch.getIdPitch());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Pitch object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(entityManager.find(Pitch.class, object.getIdPitch()));
        transaction.commit();
        entityManager.close();
    }
}
