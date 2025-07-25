package DAO;

import java.util.List;

import Entity.Users;

public interface UsersDAO {
	List<Users> findAll();                   
    Users findById(String id);              
    void create(Users user);                
    void update(Users user);                 
    void deleteById(String id);             
}
