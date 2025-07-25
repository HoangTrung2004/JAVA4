package Servlet;

import java.io.IOException;
import java.util.Date;

import DAO.ShareDAO;
import DAO.ShareDAOImpl;
import DAO.VideoDAO;
import DAO.VideoDAOImpl;
import Entity.Share;
import Entity.Users;
import Entity.Video;
import Utils.EmailUtils;
import Utils.SessionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/share")
public class ShareServlet extends HttpServlet {
    private ShareDAO shareDAO = new ShareDAOImpl();
    private VideoDAO videoDAO = new VideoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String videoId = req.getParameter("id");
        Video video = videoDAO.findById(videoId);
        req.setAttribute("video", video);
        req.getRequestDispatcher("/views/user/Share.jsp").forward(req, resp);
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
        String emails = req.getParameter("emails");

        // Gửi email (giả sử dùng EmailUtils)
        String subject = "Video chia sẻ từ bạn bè";
        String content = "Video bạn vừa chia sẻ: http://localhost:8080/asm/detail?id=" + videoId;
        EmailUtils.send(emails, subject, content); 

        // Lưu Share vào DB
        Share s = new Share();
        s.setUser(user);
        s.setVideo(videoDAO.findById(videoId));
        s.setEmails(emails);
        s.setShareDate(new Date());
        shareDAO.create(s);

        req.setAttribute("message", "Chia sẻ thành công tới: " + emails);
        doGet(req, resp);
    }
}
