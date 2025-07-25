package DAO;

import Entity.Users;
import Utils.XJPA;
import jakarta.persistence.EntityManager;

public class UsersDAOImpl implements UsersDAO {
    @Override
    public Users findById(String username) {
        EntityManager em = XJPA.getEntityManager();
        try {
            return em.find(Users.class, username);
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }
}
