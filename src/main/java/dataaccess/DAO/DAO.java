package dataaccess.DAO;

import javax.persistence.EntityManagerFactory;

public abstract class DAO<T>  {

    public abstract T findById(EntityManagerFactory entityManagerFactory, int id);

    public abstract T create (EntityManagerFactory entityManagerFactory, T object);

    public abstract T update(EntityManagerFactory entityManagerFactory, T object);

    public abstract void delete(EntityManagerFactory entityManagerFactory, T object);
}
