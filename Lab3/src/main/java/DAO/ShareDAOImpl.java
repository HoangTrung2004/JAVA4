package DAO;

import java.util.List;

import Entity.Share;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class ShareDAOImpl implements ShareDAO {
	private EntityManager em = XJPA.getEntityManager();

    public List<Share> findAll() {
        return em.createQuery("SELECT s FROM Share s", Share.class).getResultList();
    }

    public Share findById(Long id) {
        return em.find(Share.class, id);
    }

    public void create(Share share) {
        em.getTransaction().begin();
        em.persist(share);
        em.getTransaction().commit();
    }

    public void update(Share share) {
        em.getTransaction().begin();
        em.merge(share);
        em.getTransaction().commit();
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        Share share = em.find(Share.class, id);
        if (share != null) em.remove(share);
        em.getTransaction().commit();
    }
}
