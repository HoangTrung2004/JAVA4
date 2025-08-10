package Servlet;

import DAO.UsersDAO;
import DAO.UsersDAOImpl;
import Entity.Users;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UsersDAO usersDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Users user = usersDAO.findById(username);
        if (user == null) {
            req.setAttribute("error", "Sai username");
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
        } else if (!user.getPassword().equals(password)) {
            req.setAttribute("error", "Sai mật khẩu");
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
        } else {
            req.getSession().setAttribute("user", user);
            resp.sendRedirect("views/Index.jsp");
        }
    }
}
