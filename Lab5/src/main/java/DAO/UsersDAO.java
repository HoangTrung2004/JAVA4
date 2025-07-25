package DAO;

import Entity.Users;

public interface UsersDAO {
    Users findById(String username);
}
