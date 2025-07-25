package DAO;

import java.util.List;

import Entity.User;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class UserDAOImpl implements UserDAO {

    private EntityManager em = XJPA.getEntityManager();

    @Override
    public User findById(String id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> findAll() {
        String jpql = "SELECT u FROM User u";
        return em.createQuery(jpql, User.class).getResultList();
    }

    @Override
    public void create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    @Override
    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    @Override
    public void delete(String id) {
        User user = em.find(User.class, id);
        if (user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }
    }
}
