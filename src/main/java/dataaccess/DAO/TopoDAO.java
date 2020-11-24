package dataaccess.DAO;

import dataaccess.DTO.Topo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class TopoDAO extends DAO<Topo> {

    @Override
    public Topo findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Topo spot = entityManager.find(Topo.class, id);
        entityManager.close();
        return spot;
    }

    @Override
    public List<Topo> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Topo> topos = entityManager.createQuery("from Topo", Topo.class).getResultList();
        entityManager.close();
        return topos;
    }

    @Override
    public Topo create(EntityManagerFactory entityManagerFactory, Topo object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        entityManager.close();
        return entityManager.find(Topo.class, object.getIdSpot());
    }

    @Override
    public Topo update(EntityManagerFactory entityManagerFactory, int id, Topo object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Topo toUpdateTopo = entityManager.find(Topo.class, id);
        toUpdateTopo.setName(object.getName());
        toUpdateTopo.setMember(object.getMember());
        toUpdateTopo.setLocation(object.getLocation());
        toUpdateTopo.setSectors(object.getSectors());
        entityManager.persist(toUpdateTopo);
        transaction.commit();
        object = entityManager.find(Topo.class, toUpdateTopo.getIdSpot());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Topo object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Topo toDelete = entityManager.find(Topo.class, object.getIdSpot());
        System.out.println(toDelete);
        entityManager.remove(toDelete);
        transaction.commit();
        entityManager.close();
    }
}
