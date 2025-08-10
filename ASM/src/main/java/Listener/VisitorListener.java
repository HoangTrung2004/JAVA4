package Listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import java.io.*;

@WebListener
public class VisitorListener implements ServletContextListener, HttpSessionListener {
    private static final String COUNTER_FILE = "D://HK_4//BLOCK2//JAVA4/counter.txt";
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        int visitors = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(COUNTER_FILE))) {
            String line = reader.readLine();
            if (line != null) {
                visitors = Integer.parseInt(line);
            }
        } catch (Exception e) {
            visitors = 0;
        }
        ServletContext app = sce.getServletContext();
        app.setAttribute("visitors", visitors);
        System.out.println("Số lượt đọc từ file: " + visitors);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext app = se.getSession().getServletContext();
        synchronized (app) {
            Object obj = app.getAttribute("visitors");
            int visitors = (obj != null) ? (int) obj : 0;
            visitors++;
            app.setAttribute("visitors", visitors);
            System.out.println("Tăng số lượt truy cập: " + visitors);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext app = sce.getServletContext();
        Object obj = app.getAttribute("visitors");
        int visitors = (obj != null) ? (int) obj : 0;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(COUNTER_FILE))) {
            writer.write(String.valueOf(visitors));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ghi số lượt vào file: " + visitors);
    }
}
