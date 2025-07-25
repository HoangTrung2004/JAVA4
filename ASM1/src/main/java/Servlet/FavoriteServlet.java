package Servlet;

import DAO.FavoriteDAO;
import DAO.FavoriteDAOImpl;
import DAO.VideoDAO;
import DAO.VideoDAOImpl;
import Entity.Favorite;
import Entity.Users;
import Entity.Video;
import Utils.SessionUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet({"/favorite", "/unlike"})
public class FavoriteServlet extends HttpServlet {
    private final FavoriteDAO favoriteDAO = new FavoriteDAOImpl();
    private final VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Users user = (Users) SessionUtils.get(req, "user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }

        String uri = req.getRequestURI();

        // Nếu là unlike → xóa
        if (uri.contains("unlike")) {
            String videoId = req.getParameter("id");
            if (videoId != null) {
                favoriteDAO.remove(user.getId(), videoId);
            }
            resp.sendRedirect("favorite");
            return;
        }

        // Không xử lý id tại đây
        List<Video> favorites = favoriteDAO.findVideosByUser(user.getId());
        req.setAttribute("videos", favorites);
        req.getRequestDispatcher("/views/user/Favorites.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Users user = (Users) SessionUtils.get(req, "user");
        if (user == null) {
            resp.sendRedirect("login");
            return;
        }

        String videoId = req.getParameter("id");

        // NẾU CHƯA LIKE THÌ THÊM
        if (videoId != null) {
            Favorite existing = favoriteDAO.findByUserAndVideo(user.getId(), videoId);
            if (existing == null) {
                Favorite f = new Favorite();
                f.setUser(user);
                f.setVideo(videoDAO.findById(videoId));
                f.setLikeDate(new Date());
                favoriteDAO.create(f);
            }
        }

        // CHUYỂN QUA TRANG YÊU THÍCH
        resp.sendRedirect("favorite");
    }
}
