package dataaccess.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConnectionManager {

    private static EntityManagerFactory entityManagerFactory;

    private DBConnectionManager() {
    }

    public static EntityManagerFactory getEntityManagerFactory(String DBName) {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory(DBName);
        }
        return entityManagerFactory;
    }

    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
