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
import java.util.List;

@WebServlet(name="catelogServlet", urlPatterns = "/products")
public class CatelogServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/shopping.jsp").forward(req, resp);
    }
}
