package DAO;

import java.util.List;

import Entity.Favorite;

public interface FavoriteDAO {
	List<Favorite> findAll();
    Favorite findById(Long id);
    void create(Favorite fav);
    void update(Favorite fav);
    void deleteById(Long id);
}
