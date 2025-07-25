package DAO;

import Entity.User;
import java.util.List;

public interface UserDAO {
    User findById(String id);
    List<User> findAll();
    void create(User user);
    void update(User user);
    void delete(String username);
}
