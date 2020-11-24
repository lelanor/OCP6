package dataaccess.DAO;

import dataaccess.DTO.Level;
import dataaccess.DTO.Pitch;
import dataaccess.DTO.Track;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrackDAOTest {

    EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void connectBase() {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        System.out.println("connection OK");
    }

    @Test
    void createTest() {

    }

    @AfterEach
    void closeConnection() {
        entityManagerFactory.close();
        System.out.println("Connection closed");
    }
}
