package Servlet;

import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import Entity.Users;
import Utils.CookieUtils;
import Utils.SessionUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Lấy cookie nếu có để hiển thị lên form
        String userId = CookieUtils.get("userId", req);
        String password = CookieUtils.get("password", req);

        req.setAttribute("userId", userId);
        req.setAttribute("password", password);

        req.getRequestDispatcher("/views/user/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        boolean remember = req.getParameter("remember") != null;

        Users user = usersDAO.findById(userId);
        if (user != null && user.getPassword().equals(password)) {
            SessionUtils.set(req, "user", user); // lưu vào session

            if (remember) {
                CookieUtils.add("userId", userId, 24, resp);
                CookieUtils.add("password", password, 24, resp);
            } else {
                CookieUtils.remove("userId", resp);
                CookieUtils.remove("password", resp);
            }

            // Trở về trang được yêu cầu trước đó (nếu có)
            String url = (String) req.getSession().getAttribute("back-url");
            if (url != null) {
                resp.sendRedirect(url);
                return;
            }

            resp.sendRedirect("home");
        } else {
            req.setAttribute("message", "Sai tài khoản hoặc mật khẩu!");
            req.getRequestDispatcher("/views/user/Login.jsp").forward(req, resp);
        }
    }
}
