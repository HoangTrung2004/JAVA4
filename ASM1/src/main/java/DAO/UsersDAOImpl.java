package DAO;

import java.util.List;
import jakarta.persistence.*;
import Entity.Users;
import Utils.XJPA;

public class UsersDAOImpl implements UsersDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public Users findById(String id) {
        return em.find(Users.class, id);
    }

    @Override
    public Users findByEmail(String email) {
        String jpql = "SELECT u FROM Users u WHERE u.email = :email";
        return em.createQuery(jpql, Users.class)
                 .setParameter("email", email)
                 .getResultStream().findFirst().orElse(null);
    }



    @Override
    public List<Users> findAll() {
        return em.createQuery("FROM Users", Users.class).getResultList();
    }

    @Override
    public void create(Users user) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    @Override
    public void update(Users user) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(user);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    @Override
    public void delete(String id) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Users u = em.find(Users.class, id);
            if (u != null) em.remove(u);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    @Override
    public Users login(String id, String password) {
        String jpql = "SELECT u FROM Users u WHERE u.id = :id AND u.password = :pass";
        return em.createQuery(jpql, Users.class)
                 .setParameter("id", id)
                 .setParameter("pass", password)
                 .getResultStream().findFirst().orElse(null);
    }
}
