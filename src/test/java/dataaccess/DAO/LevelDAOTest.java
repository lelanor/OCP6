package dataaccess.DAO;

import dataaccess.DTO.Level;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LevelDAOTest {

    EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void connectBase() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        System.out.println("connection OK");
    }

    @Test
    void findByIdTest() {
        LevelDAO dao = new LevelDAO();
        Level result = dao.findById(entityManagerFactory, 13);
        assertEquals("7a", result.getDegree());
    }

    @Test
    void createTest() {
        LevelDAO dao = new LevelDAO();
        Level newLevel = new Level("create test");
        Level checkLevel = dao.create(entityManagerFactory, newLevel);
        assertEquals(newLevel, checkLevel);
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(em.contains(checkLevel) ? checkLevel : em.merge(checkLevel));
        transaction.commit();
        em.close();
    }

    @Test
    void update() {
        LevelDAO dao = new LevelDAO();
        Level updatedLevel = new Level("update test");
        Level checkLevel = dao.update(entityManagerFactory,1,updatedLevel);

    }

    @Test
    void delete() {
    }

    @AfterEach
    void closeConnection() {
        entityManagerFactory.close();
        System.out.println("Connection closed");
    }
}
