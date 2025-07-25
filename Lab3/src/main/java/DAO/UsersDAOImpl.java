package DAO;

import java.util.List;

import Entity.Users;
import Utils.XJPA;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

public class UsersDAOImpl implements UsersDAO {

	private EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Users> findAll() {
        TypedQuery<Users> query = em.createQuery("SELECT u FROM Users u", Users.class);
        return query.getResultList();
    }

    @Override
    public Users findById(String id) {
        return em.find(Users.class, id);
    }

    @Override
    public void create(Users user) {
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void update(Users user) {
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void deleteById(String id) {
        try {
            em.getTransaction().begin();
            Users user = em.find(Users.class, id);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }

}
