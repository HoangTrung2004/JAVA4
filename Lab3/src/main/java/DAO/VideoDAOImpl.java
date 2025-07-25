package DAO;

import java.util.List;

import Entity.Video;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class VideoDAOImpl implements VideoDAO {
	private EntityManager em = XJPA.getEntityManager();

    public List<Video> findAll() {
        return em.createQuery("SELECT v FROM Video v", Video.class).getResultList();
    }

    public Video findById(String id) {
        return em.find(Video.class, id);
    }

    public void create(Video video) {
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();
    }

    public void update(Video video) {
        em.getTransaction().begin();
        em.merge(video);
        em.getTransaction().commit();
    }

    public void deleteById(String id) {
        em.getTransaction().begin();
        Video video = em.find(Video.class, id);
        if (video != null) em.remove(video);
        em.getTransaction().commit();
    }
}
