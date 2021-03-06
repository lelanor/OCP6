package dataaccess.utils;

import dataaccess.DAO.LevelDAO;
import dataaccess.DTO.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ConsoleJPA {

    public static void main(String[] args) throws Exception{
       /* EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;

        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("default");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println("----------------- lecture de tous les niveaux -----------------");
            List<Level> levels = entityManager.createQuery("from Level ", Level.class).getResultList();
            for (Level level:levels) {
                System.out.println(level);
            }

            System.out.println("----------------- Ajout d'un niveau -----------------");
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Level newLevel = new Level("1");
            entityManager.persist(newLevel);
            transaction.commit();

            levels = entityManager.createQuery("from Level ", Level.class).getResultList();
            for (Level level:levels) {
                System.out.println(level);
            }

        } finally {
            if (entityManager!=null) entityManager.close();
            if (entityManagerFactory!=null) entityManagerFactory.close();
        }*/
/*
        EntityManagerFactory emf = DBConnectionManager.getEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("----------------- lecture de tous les niveaux -----------------");
        List<Level> levels = entityManager.createQuery("from Level ", Level.class).getResultList();
        for (Level level:levels) {
            System.out.println(level);
        }*/
        LevelDAO levelDAO = new LevelDAO();
        System.out.println(levelDAO.findById(DBConnectionManager.getEntityManagerFactory("default"),1));
        Level level = levelDAO.findById(DBConnectionManager.getEntityManagerFactory("default"),1);
        levelDAO.delete(DBConnectionManager.getEntityManagerFactory("default"),level);
        System.out.println(levelDAO.findById(DBConnectionManager.getEntityManagerFactory("default"),1));
        DBConnectionManager.closeEntityManagerFactory();

    }
}
