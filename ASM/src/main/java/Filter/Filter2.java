package Filter;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // In ra thuộc tính hello đã được set ở filter 1
        System.out.print(request.getAttribute("hello"));
        chain.doFilter(request, response);
    }
}
