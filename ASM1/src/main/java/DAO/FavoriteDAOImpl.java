package DAO;

import java.util.List;
import jakarta.persistence.*;
import Entity.Favorite;
import Entity.Video;
import Utils.XJPA;

public class FavoriteDAOImpl implements FavoriteDAO {
    EntityManager em = XJPA.getEntityManager();

    @Override
    public List<Favorite> findByUser(String userId) {
        String jpql = "SELECT f FROM Favorite f WHERE f.user.id = :uid";
        return em.createQuery(jpql, Favorite.class).setParameter("uid", userId).getResultList();
    }

    @Override
    public Favorite findByUserAndVideo(String userId, String videoId) {
        String jpql = "SELECT f FROM Favorite f WHERE f.user.id = :uid AND f.video.id = :vid";
        return em.createQuery(jpql, Favorite.class)
                 .setParameter("uid", userId)
                 .setParameter("vid", videoId)
                 .getResultStream().findFirst().orElse(null);
    }

    @Override
    public void create(Favorite fav) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            em.persist(fav);
            em.flush(); // buộc đẩy vào DB
            System.out.println("▶ Favorite created: " + fav.getUser().getId() + " - " + fav.getVideo().getId());
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            e.printStackTrace(); 
            throw e;
        }
    }


    @Override
    public void delete(Long id) {
        EntityTransaction trans = em.getTransaction();
        try {
            trans.begin();
            Favorite f = em.find(Favorite.class, id);
            if (f != null) em.remove(f);
            trans.commit();
        } catch (Exception e) {
            trans.rollback();
            throw e;
        }
    }


	@Override
	public void remove(String userId, String videoId) {
		Favorite f = findByUserAndVideo(userId, videoId);
	    if (f != null) {
	        em.getTransaction().begin();
	        em.remove(em.merge(f));
	        em.getTransaction().commit();
	    }
		
	}

	@Override
	public List<Video> findVideosByUser(String userId) {
	    String jpql = "SELECT f.video FROM Favorite f WHERE f.user.id = :uid";
	    List<Video> list = em.createQuery(jpql, Video.class)
                .setParameter("uid", userId)
                .getResultList();
System.out.println("▶ Videos liked by " + userId + ": " + list.size());
return list;

	}
}
