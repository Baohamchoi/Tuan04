package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.controller;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.TinTucDAO;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.impl.TinTucImpl;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Tintuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Tin tuc", urlPatterns = "/news")
public class TinTucServlet extends HttpServlet {
    TinTucDAO tinTucDAO = new TinTucImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tintuc> tintucList = tinTucDAO.getAll();
        req.setAttribute("tintucList", tintucList);
//        System.out.println("Test:" + tintucList);
        req.getRequestDispatcher("newsList.jsp").forward(req, resp);
    }
}
