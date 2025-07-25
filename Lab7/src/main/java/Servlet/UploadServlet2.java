package Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.nio.file.Files;

@WebServlet("/upload") // KHÔNG để /Lab7/upload, chỉ để /upload thôi!
@MultipartConfig
public class UploadServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Lấy file từ form (key "file")
        Part filePart = req.getPart("file");
        String fileName = filePart.getSubmittedFileName();
        String type = filePart.getContentType();
        long size = filePart.getSize();

        // Đường dẫn thực tế thư mục uploads trong webapp
        String appPath = req.getServletContext().getRealPath("/uploads");
        File uploadDir = new File(appPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();

        // Lưu file vào thư mục uploads
        File file = new File(uploadDir, fileName);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, file.toPath(), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        }

        // Trả về thông tin file dạng JSON
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");
        String json = String.format(
            "{\"name\":\"%s\", \"type\":\"%s\", \"size\":%d}",
            fileName, type, size
        );
        resp.getWriter().write(json);
    }
}
