package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.controllers;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.Impl.ProductImpl;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="productList", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    private ProductDAO productDAO = new ProductImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productDAO.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/productList.jsp").forward(req, resp);
    }
}
