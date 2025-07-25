package DAO;

import java.util.List;
import Entity.Favorite;
import Entity.Video;

public interface FavoriteDAO {
    List<Favorite> findByUser(String userId);
    Favorite findByUserAndVideo(String userId, String videoId);
    void create(Favorite fav);
    void delete(Long id);
    List<Video> findVideosByUser(String userId);
    void remove(String userId, String videoId);

}
