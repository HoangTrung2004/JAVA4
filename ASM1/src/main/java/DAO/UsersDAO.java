package DAO;

import java.util.List;
import Entity.Users;

public interface UsersDAO {
    Users findById(String id);
    Users findByEmail(String email);
    List<Users> findAll();
    void create(Users user);
    void update(Users user);
    void delete(String id);
    Users login(String id, String password);
    
}
