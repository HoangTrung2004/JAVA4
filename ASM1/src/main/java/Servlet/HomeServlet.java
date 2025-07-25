package Servlet;

import DAO.VideoDAO;
import DAO.VideoDAOImpl;
import Entity.Video;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int page = 1;
        int size = 6;

        // Lấy số trang từ query string nếu có
        String pageParam = req.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            page = Integer.parseInt(pageParam);
        }

        // Lấy video phân trang
        List<Video> videos = videoDAO.findPage(page, size);
        int totalVideos = videoDAO.count(); // cần thêm count() trong DAO
        int totalPage = (int) Math.ceil(totalVideos * 1.0 / size);

        req.setAttribute("videos", videos);
        req.setAttribute("page", page);
        req.setAttribute("totalPage", totalPage);

        req.getRequestDispatcher("/views/user/index.jsp").forward(req, resp);
    }
}


