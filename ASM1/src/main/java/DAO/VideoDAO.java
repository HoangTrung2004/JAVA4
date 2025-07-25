package DAO;

import java.util.List;
import Entity.Video;

public interface VideoDAO {
    Video findById(String id);
    List<Video> findAll();
    void create(Video video);
    void update(Video video);
    void delete(String id);
    List<Video> findTop6ByViews();
	List<Video> findPage(int page, int size);
	int count();

}
