package DAO;

import java.util.List;

import Entity.Share;

public interface ShareDAO {
	List<Share> findAll();
    Share findById(Long id);
    void create(Share share);
    void update(Share share);
    void deleteById(Long id);
}
