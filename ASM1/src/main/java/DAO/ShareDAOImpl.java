package DAO;

import java.util.List;
import jakarta.persistence.*;
import Entity.Share;
import Utils.XJPA;

public class ShareDAOImpl implements ShareDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Share> findByUser(String userId) {
        String jpql = "SELECT s FROM Share s WHERE s.user.id = :uid";
        return em.createQuery(jpql, Share.class).setParameter("uid", userId).getResultList();
    }

    @Override
    public void create(Share share) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(share);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }
}
