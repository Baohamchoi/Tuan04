package iuh.fit.se.bai03_22690761_nguyenhuynhthebao.controller;

import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.DanhMucDAO;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.TinTucDAO;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.impl.DanhMucImpl;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.dao.impl.TinTucImpl;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Danhmuc;
import iuh.fit.se.bai03_22690761_nguyenhuynhthebao.model.Tintuc;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "Them tin tuc moi", urlPatterns = "/add-new")
public class ThemTinTucServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // tránh lỗi tiếng Việt

        TinTucDAO tinTucDAO = new TinTucImpl();
        DanhMucDAO danhMucDAO = new DanhMucImpl();

        String tieuDe = req.getParameter("tieuDe");
        String noiDung = req.getParameter("noiDung");
        String danhMuc = req.getParameter("danhMuc");
        LocalDate ngayDang = LocalDate.now();

        Danhmuc danhMuc2 = danhMucDAO.findByName(danhMuc);
//
        Tintuc tintuc = new Tintuc(0, tieuDe, noiDung, danhMuc2.getMaDM(), ngayDang);
        tinTucDAO.save(tintuc);
    }
}
