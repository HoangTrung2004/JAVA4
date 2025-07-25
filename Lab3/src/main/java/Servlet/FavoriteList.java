package Servlet;

import java.io.IOException;
import java.util.List;

import DAO.FavoriteDAOImpl;
import Entity.Favorite;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/FavoriteList")
public class FavoriteList extends HttpServlet {
    private FavoriteDAOImpl favoriteDAO = new FavoriteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Favorite> favorites = favoriteDAO.findAll(); 

        request.setAttribute("favorites", favorites);
        request.getRequestDispatcher("/views/favorite-list.jsp").forward(request, response);
    }
}
