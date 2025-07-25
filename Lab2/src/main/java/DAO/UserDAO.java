package DAO;

import java.util.List;

import Entity.User;

public interface UserDAO {
	List<User> findAll();

    User findById(String id);

    void create(User item);

    void update(User item);

    void deleteById(String id);
}
