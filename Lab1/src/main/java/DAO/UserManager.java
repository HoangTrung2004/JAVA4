package DAO;

import java.util.List;

import Entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserManager {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("Lab1");
    private EntityManager em = factory.createEntityManager();

    public void findAll() {
        String jpql = "SELECT o FROM User o";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        List<User> list = query.getResultList();
        list.forEach(user -> {
            String fullname = user.getFullname();
            boolean admin   = user.getAdmin();
            System.out.println(fullname + ":" + admin);
        });
    }

    public void findById() {
       
        User user = em.find(User.class, "admin01");
        String fullname = user.getFullname();
        boolean admin   = user.getAdmin();
        System.out.println(fullname + ":" + admin);
    }

    
    public void create() {
        User user = new User("admin07", "1234", "Nguyễn Văn Khờ", "kho@poly.edu.vn", true);
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(user);
            tx.commit();
            System.out.println("Tạo thành công!");
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();  
        }
    }



    public void update() {
        User user = em.find(User.class, "admin01");
        user.setFullname("Nguyễn Hoàng Trung");
        user.setEmail("trungam@fpt.edu.vn");
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    public void deleteById() {
        User user = em.find(User.class, "admin06");
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }
    
    public void findByEmailDomainAndNotAdmin() {
        String jpql = "SELECT u FROM User u WHERE u.email LIKE :search AND u.admin = :role";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setParameter("search", "%fpt.edu.vn");
        query.setParameter("role", true);
        List<User> list = query.getResultList();
        System.out.println("=== Danh sách admin có email @fpt.edu.vn ===");
        list.forEach(u -> System.out.println(u.getFullname() + " – " + u.getEmail()));
    }

    
    public void findPage(int pageIndex, int pageSize) {
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = em.createQuery(jpql, User.class);
        query.setFirstResult(pageIndex * pageSize);
        query.setMaxResults(pageSize);
        List<User> list = query.getResultList();
        System.out.println("=== Page " + (pageIndex+1) + " (pageSize=" + pageSize + ") ===");
        list.forEach(u -> System.out.println(u.getFullname() + " – " + u.getEmail()));
    }

    
    public static void main(String[] args) {
    	 UserManager dao = new UserManager();
    	 System.out.println("Tất cả ");
    	 dao.findAll();
//    	 
//    	 System.out.println("_______________________");
//    	 System.out.println("Theo ID admin01:");
//    	 dao.findById();
//    	 
//    	 System.out.println("_______________________");
//    	 System.out.println("=== Sau khi đã thêm admin06 ===");
//    	 dao.create();
//    	 dao.findAll();
    	 
//    	 System.out.println("_______________________");
//  	 dao.update();
//    	 dao.findAll();
//    	 
//    	 System.out.println("_______________________");
//    	 dao.deleteById();
//    	 dao.findAll();
//    	 dao.findByEmailDomainAndNotAdmin();    	 
//    	 dao.findPage(0, 5);
    	 
    	 
	}
}
