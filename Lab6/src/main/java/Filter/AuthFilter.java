package Filter;

import Entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebFilter({
    "/admin/*",
    "/account/change-password",
    "/account/edit-profile",
    "/video/like/*",
    "/video/share/*"
})
public class AuthFilter implements Filter {
    public static final String SECURITY_URI = "securityUri";

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        String uri = req.getRequestURI();

        if (user == null || (uri.contains("/admin/") && !user.isAdmin())) {
            // Lưu lại đường dẫn yêu cầu để sau khi đăng nhập quay lại
            session.setAttribute(AuthFilter.SECURITY_URI, uri);
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }
}
