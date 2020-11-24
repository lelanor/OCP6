package dataaccess.DAO;

import dataaccess.DTO.Level;
import dataaccess.DTO.Pitch;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PitchDAOTest {

    EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void connectBase() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        System.out.println("connection OK");
    }


    @Test
    void embarkingLevelTest() {
        PitchDAO dao = new PitchDAO();
        assertEquals("4a", dao.findById(entityManagerFactory, 11).getDegree().getDegree());
    }

    @Test
    void createTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Level level = entityManager.find(Level.class, 10);
        Pitch pitchToPersist = new Pitch("test pitch", level);
        PitchDAO dao = new PitchDAO();
        transaction.begin();
        Pitch persistedPitch = dao.create(entityManagerFactory, pitchToPersist);
        transaction.commit();
        assertEquals(pitchToPersist, persistedPitch);
        transaction.begin();
        persistedPitch = entityManager.find(Pitch.class, persistedPitch.getIdPitch());
        entityManager.remove(persistedPitch);
        System.out.println("entity removed");
        transaction.commit();
        entityManager.close();
    }

    @Test
    void updateTest() {
        EntityManager em = entityManagerFactory.createEntityManager();
        PitchDAO dao = new PitchDAO();
        Pitch newPitch = em.find(Pitch.class, 11);
        newPitch.setName("test pitch");
        Pitch updatedPitch = dao.update(entityManagerFactory, 11, newPitch);
        assertEquals(newPitch.getName(), updatedPitch.getName());
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        newPitch.setName("charlie");
        em.persist(newPitch);
        transaction.commit();
        em.close();
    }

    @AfterEach
    void closeConnection() {
        entityManagerFactory.close();
        System.out.println("Connection closed");
    }
}
