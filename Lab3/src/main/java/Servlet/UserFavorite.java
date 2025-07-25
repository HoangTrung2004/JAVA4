package Servlet;


import java.io.IOException;
import java.util.List;

import DAO.UsersDAOImpl;
import Entity.Favorite;
import Entity.Users;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user-favorites")
public class UserFavorite extends HttpServlet {
    private UsersDAOImpl userDAO = new UsersDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userId = request.getParameter("id"); 
        if (userId != null) {
            Users user = userDAO.findById(userId);

        if (user != null) {
                List<Favorite> favorites = user.getFavorites();

                request.setAttribute("user", user);
                request.setAttribute("favorites", favorites);
            }
        }

        request.getRequestDispatcher("/views/user-favorite.jsp").forward(request, response);
        //?id=admin01
    }
}
