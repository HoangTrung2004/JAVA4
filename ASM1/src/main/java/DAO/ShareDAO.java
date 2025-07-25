package DAO;

import java.util.List;
import Entity.Share;

public interface ShareDAO {
    List<Share> findByUser(String userId);
    void create(Share share);
}
