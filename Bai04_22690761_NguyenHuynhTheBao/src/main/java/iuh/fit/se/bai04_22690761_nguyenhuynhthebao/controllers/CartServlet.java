package iuh.fit.se.bai04_22690761_nguyenhuynhthebao.controllers;

import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.HelloServlet;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.CartDAO;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.ProductDAO;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.impl.CartDAOImpl;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.daos.impl.ProductDAOImpl;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Cart;
import iuh.fit.se.bai04_22690761_nguyenhuynhthebao.entities.Product;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "cartServle", urlPatterns={"/cart", "/cart*"})
public class CartServlet extends HelloServlet {
    private CartDAO cart;
    private ProductDAO productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        productDAO = new ProductDAOImpl();
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/cart.jsp").forward(request, response);
    }

    private void handleUpdateProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        String index=req.getParameter("index");
        int quantity= Integer.parseInt(req.getParameter("quantity"));
        System.out.println(index);
        System.out.println(quantity);
        cart.updateItem(index,quantity);
        cart.totalOrder();
        System.out.println(cart.getCartItem());
        session.setAttribute("cart",cart);
        req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
    }

    private void handleDeleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String index=req.getParameter("index");
        cart.deleteItem(index);
        cart.totalOrder();
        session.setAttribute("cart",cart);
        req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
    }

    private void handleAddProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session =req.getSession();
        Object object =session.getAttribute("cart");
        if (object != null) {
            cart = (CartDAO) object;
        } else {
            cart = new CartDAOImpl();
            session.setAttribute("cart", cart);

            String name = req.getParameter("name");
            Product product = productDAO.findByName(name);
            int quantity= Integer.parseInt(req.getParameter("quantity"));
            Cart cartItem=new Cart();
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setId(cart.getCartItem().size() +1);
            cart.addItem(cartItem);
            cart.totalOrder();
            session.setAttribute("cart",cart);
            req.getRequestDispatcher("/views/cart.jsp").forward(req,resp);
        }
    }
}
