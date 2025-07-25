package Servlet;

import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import Entity.Users;
import Utils.EmailUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/forgot")
public class ForgotPasswordServlet extends HttpServlet {
    private final UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/ForgotPassword.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String email = req.getParameter("email");
        String username = req.getParameter("username");

        Users user = usersDAO.findById(username);

        if (user == null || !user.getEmail().equalsIgnoreCase(email)) {
            req.setAttribute("message", "Sai thông tin username hoặc email!");
        } else {
            try {
                String subject = "Mật khẩu của bạn";
                String content = "Mật khẩu đăng nhập của bạn là: " + user.getPassword();
                EmailUtils.send(email, subject, content);
                req.setAttribute("message", "Mật khẩu đã được gửi tới: " + email);
            } catch (Exception e) {
                e.printStackTrace();
                req.setAttribute("message", "Lỗi gửi email. Vui lòng thử lại sau.");
            }
        }

        req.getRequestDispatcher("/views/user/ForgotPassword.jsp").forward(req, resp);
    }
    
}
