package dataaccess.DAO;

import dataaccess.DTO.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class MemberDAO extends DAO<Member> {

    @Override
    public Member findById(EntityManagerFactory entityManagerFactory, int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Member member = entityManager.find(Member.class, id);
        entityManager.close();
        return member;
    }

    @Override
    public List<Member> findAll(EntityManagerFactory entityManagerFactory) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Member> members = entityManager.createQuery("from Member", Member.class).getResultList();
        entityManager.close();
        return members;
    }

    @Override
    public Member create(EntityManagerFactory entityManagerFactory, Member object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(object);
        transaction.commit();
        entityManager.close();
        return entityManager.find(Member.class, object.getIdMember());
    }

    @Override
    public Member update(EntityManagerFactory entityManagerFactory, int id, Member object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Member toUpdateMember = entityManager.find(Member.class, id);
        toUpdateMember.setName(object.getName());
        toUpdateMember.setEmail(object.getEmail());
        toUpdateMember.setPassword(object.getPassword());
        entityManager.persist(toUpdateMember);
        transaction.commit();
        object = entityManager.find(Member.class, toUpdateMember.getIdMember());
        entityManager.close();
        return object;
    }

    @Override
    public void delete(EntityManagerFactory entityManagerFactory, Member object) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Member toDelete = entityManager.find(Member.class, object.getIdMember());
        System.out.println(toDelete);
        entityManager.remove(toDelete);
        transaction.commit();
        entityManager.close();
    }
}
