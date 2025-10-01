package iuh.fit.se.bai02_22690761_nguyenhuynhthebao.controllers;

import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.CartDAO;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.Impl.ProductImpl;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Cart;
import iuh.fit.se.bai02_22690761_nguyenhuynhthebao.models.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "cartServlet", urlPatterns = {"/cart", "/cart*"})
public class CartController extends HttpServlet {
    private CartDAO cartDAO;
    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) action = "";

        switch (action) {
            case "add":
                handleAddProduct(req, resp);
                break;
            case "delete":
                handleDeleteProduct(req, resp);
                break;
            case "update":
                handleUpdateProduct(req, resp);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
    }

    private void handleUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        String index=req.getParameter("index");
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        System.out.println(index);
        System.out.println(quantity);
        cartDAO.updateItem(index,quantity);
        cartDAO.totalOrder();
        System.out.println(cartDAO.getCartItem());
        session.setAttribute("cart",cartDAO);
        req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
    }

    private void handleDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String index=req.getParameter("index");
        cartDAO.deleteItem(index);
        cartDAO.totalOrder();
        session.setAttribute("cart",cartDAO);
        req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
    }

    private void handleAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("id");
        if (productId == null) {
            resp.sendRedirect("products");
            return;
        }
        Product product = productDAO.findById(productId);

        if (product == null) {
            resp.sendRedirect("products");
            return;
        }

        HttpSession session = req.getSession();
        List<Cart> cartList = (List<Cart>) session.getAttribute("cart");

        if (cartList == null) {
            cartList = new ArrayList<>();
        }

        boolean found = false;
        for (Cart c : cartList) {
            if (c.getProduct().getId() == product.getId()) {
                c.setQuantity(c.getQuantity() + 1);
                found = true;
                break;
            }
        }

        if (!found) {
            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setQuantity(1);
            cartList.add(cart);
        }

        session.setAttribute("cart", cartList);

        resp.sendRedirect("/views/cart.jsp");
    }
}


