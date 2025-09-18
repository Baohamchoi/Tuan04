package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.controllers;

import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.impl.ProductDAOImpl;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");

        Product product = productDAO.findById(id);
        if (product != null && product.getImage() != null) {
            resp.setContentType("image/jpeg");
            resp.getOutputStream().write(product.getImage());
        } else {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
