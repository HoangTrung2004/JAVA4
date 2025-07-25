package Servlet;

import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import Entity.Users;
import Utils.EmailUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/Register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String id = req.getParameter("id");
        String fullname = req.getParameter("fullname");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        Users existId = usersDAO.findById(id);
        Users existEmail = usersDAO.findByEmail(email);

        if (existId != null) {
            req.setAttribute("message", "Tài khoản đã tồn tại!");
        } else if (existEmail != null) {
            req.setAttribute("message", "Email đã được sử dụng!");
        } else {
            Users user = new Users();
            user.setId(id);
            user.setFullname(fullname);
            user.setPassword(password);
            user.setEmail(email);
            user.setAdmin(false);

            usersDAO.create(user);

            // Gửi email chào mừng (nếu có)
            try {
                EmailUtils.send(email, "Welcome to OE", "Chào mừng bạn đến với hệ thống OE!");
            } catch (Exception e) {
                e.printStackTrace();
            }

            req.setAttribute("message", "Đăng ký thành công! Vui lòng đăng nhập.");
        }

        req.getRequestDispatcher("/views/user/Register.jsp").forward(req, resp);
    }
}
