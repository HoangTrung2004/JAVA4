package Servlet;

import DAO.VideoDAO;
import DAO.VideoDAOImpl;
import Entity.Video;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String videoId = req.getParameter("id");
        if (videoId == null || videoId.isEmpty()) {
            resp.sendRedirect("home");
            return;
        }

        // Tìm video
        Video video = videoDAO.findById(videoId);
        if (video == null) {
            resp.sendRedirect("home");
            return;
        }

        // Tăng lượt xem
        video.setViews(video.getViews() + 1);
        videoDAO.update(video);

        // Ghi vào cookie "watched"
        Cookie cookie = new Cookie("watched_" + videoId, URLEncoder.encode(video.getTitle(), "UTF-8"));
        cookie.setMaxAge(60 * 60 * 24); 
        resp.addCookie(cookie);

        // Lấy danh sách video đã xem từ cookie
        List<Video> watchedVideos = new ArrayList<>();
        for (Cookie c : req.getCookies()) {
            if (c.getName().startsWith("watched_")) {
                String id = c.getName().substring(8);
                Video v = videoDAO.findById(id);
                if (v != null) watchedVideos.add(v);
            }
        }

        req.setAttribute("video", video);
        req.setAttribute("watched", watchedVideos);
        req.getRequestDispatcher("/views/user/Detail.jsp").forward(req, resp);
    }
}
