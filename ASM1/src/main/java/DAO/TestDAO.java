package DAO;

import java.util.Date;
import java.util.List;

import DAO.*;
import Entity.*;
import Utils.XJPA;

public class TestDAO {
    public static void main(String[] args) {
        // Test Users
        UsersDAO userDao = new UsersDAOImpl();
        System.out.println("---- TẤT CẢ USERS ----");
        List<Users> users = userDao.findAll();
        for (Users u : users) {
            System.out.println(u.getId() + " - " + u.getFullname() + " - " + u.getEmail());
        }

        Users user = userDao.findById("user01");
        System.out.println("\n---- TÌM USER user01 ----");
        if (user != null) {
            System.out.println("Tên: " + user.getFullname() + ", Email: " + user.getEmail());
        }

        // Test Video
        VideoDAO videoDao = new VideoDAOImpl();
        System.out.println("\n---- TOP 6 VIDEO ----");
        List<Video> videos = videoDao.findTop6ByViews();
        for (Video v : videos) {
            System.out.println(v.getId() + " - " + v.getTitle() + " (" + v.getViews() + " views)");
        }

        // Test Favorite
        FavoriteDAO favDao = new FavoriteDAOImpl();
        System.out.println("\n---- FAVORITE của user01 ----");
        List<Favorite> favs = favDao.findByUser("user01");
        for (Favorite f : favs) {
            System.out.println("Video: " + f.getVideo().getTitle() + ", Ngày like: " + f.getLikeDate());
        }

        // Test Share
        ShareDAO shareDao = new ShareDAOImpl();
        System.out.println("\n---- SHARE của admin01 ----");
        List<Share> shares = shareDao.findByUser("admin01");
        for (Share s : shares) {
            System.out.println("Video: " + s.getVideo().getTitle() + ", Gửi tới: " + s.getEmails());
        }

        // Test create Favorite (tùy chọn test)
        /*
        Favorite newFav = new Favorite();
        newFav.setUser(userDao.findById("user02"));
        newFav.setVideo(videoDao.findById("v2"));
        newFav.setLikeDate(new java.sql.Date(new Date().getTime()));
        favDao.create(newFav);
        System.out.println("→ Đã thêm favorite mới!");
        */

        // Test login
        Users login = userDao.login("admin01", "123");
        System.out.println("\nLogin result: " + (login != null ? login.getFullname() : "Sai tài khoản/mật khẩu"));


    }
}
