package dataaccess.DAO;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public abstract class DAO<T> {

    public abstract T findById(EntityManagerFactory entityManagerFactory, int id);

    public abstract List<T> findAll(EntityManagerFactory entityManagerFactory);

    public abstract T create(EntityManagerFactory entityManagerFactory, T object);

    public abstract T update(EntityManagerFactory entityManagerFactory, int id, T object);

    public abstract void delete(EntityManagerFactory entityManagerFactory, T object);
}
