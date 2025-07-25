package Servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import org.apache.commons.beanutils.BeanUtils;
import DAO.UserDAO;
import DAO.UserManagerDAOImpl;
import Entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
    "/user",             
    "/user/create",
    "/user/update",
    "/user/delete",
    "/user/edit",
    "/user/reset"
})
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	req.setCharacterEncoding("UTF-8");
    	resp.setCharacterEncoding("UTF-8");

        UserDAO dao = new UserManagerDAOImpl();

        User form = new User();
        try {
            BeanUtils.populate(form, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        
        String path = req.getServletPath();
        String message = "Enter user information";

        
        if (path.contains("edit")) {
            String id = req.getParameter("id");
            form = dao.findById(id);
            message = "Editing user: " + id;
        } else if (path.contains("create")) {
            dao.create(form);
            form = new User();
            message = "User created: " + form.getId();
        } else if (path.contains("update")) {
            dao.update(form);
            message = "User updated: " + form.getId();
        } else if (path.contains("delete")) {
            String id = req.getParameter("id");
            dao.deleteById(id);
            form = new User();
            message = "User deleted: " + id;
        } else if (path.contains("reset")) {
            form = new User();
            message = "Form reset";
        } 

        List<User> list = dao.findAll();

        req.setAttribute("form", form);
        req.setAttribute("list", list);
        req.setAttribute("message", message);
        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);
    }
}
