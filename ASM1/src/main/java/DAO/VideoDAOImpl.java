package DAO;

import java.util.List;
import jakarta.persistence.*;
import Entity.Video;
import Utils.XJPA;

public class VideoDAOImpl implements VideoDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    @Override
    public List<Video> findAll() {
        return em.createQuery("FROM Video", Video.class).getResultList();
    }

    @Override
    public void create(Video video) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(video);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    @Override
    public void update(Video video) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.merge(video);
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
            Video v = em.find(Video.class, id);
            if (v != null) em.remove(v);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }

    @Override
    public List<Video> findTop6ByViews() {
        String jpql = "SELECT v FROM Video v WHERE v.active = true ORDER BY v.views DESC";
        return em.createQuery(jpql, Video.class).setMaxResults(6).getResultList();
    }

    @Override
    public List<Video> findPage(int page, int size) {
        return em.createQuery("SELECT v FROM Video v WHERE v.active = true ORDER BY v.views DESC", Video.class)
                 .setFirstResult((page - 1) * size)
                 .setMaxResults(size)
                 .getResultList();
    }


    @Override
    public int count() {
        return em.createQuery("SELECT COUNT(v) FROM Video v WHERE v.active = true", Long.class)
                 .getSingleResult().intValue();
    }

}
