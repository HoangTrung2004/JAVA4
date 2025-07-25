package DAO;

import java.util.List;

import Entity.Favorite;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class FavoriteDAOImpl implements FavoriteDAO {
	private EntityManager em = XJPA.getEntityManager();

    public List<Favorite> findAll() {
        return em.createQuery("SELECT f FROM Favorite f", Favorite.class).getResultList();
    }

    public Favorite findById(Long id) {
        return em.find(Favorite.class, id);
    }

    public void create(Favorite fav) {
        em.getTransaction().begin();
        em.persist(fav);
        em.getTransaction().commit();
    }

    public void update(Favorite fav) {
        em.getTransaction().begin();
        em.merge(fav);
        em.getTransaction().commit();
    }

    public void deleteById(Long id) {
        em.getTransaction().begin();
        Favorite fav = em.find(Favorite.class, id);
        if (fav != null) em.remove(fav);
        em.getTransaction().commit();
    }
    public static void main(String[] args) {
        FavoriteDAOImpl dao = new FavoriteDAOImpl();

        List<Favorite> list = dao.findAll();

        if (list.isEmpty()) {
            System.out.println("Không có bản ghi nào trong bảng Favorite.");
        } else {
            System.out.println("Danh sách video đã được yêu thích:");
            for (Favorite fav : list) {
                System.out.println(" - User: " + fav.getUser().getFullname());
                System.out.println("   Video: " + fav.getVideo().getTitle());
                System.out.println("   Ngày thích: " + fav.getLikeDate());
                System.out.println("-----------------------------");
            }
        }
    }
}
