package iuh.fit.se.nguyenhuynhthebao_22690761.bai01.controllers;

import iuh.fit.se.nguyenhuynhthebao_22690761.bai01.daos.UserDAO;
import iuh.fit.se.nguyenhuynhthebao_22690761.bai01.daos.impl.UserDAOImpl;
import iuh.fit.se.nguyenhuynhthebao_22690761.bai01.entities.Gender;
import iuh.fit.se.nguyenhuynhthebao_22690761.bai01.entities.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAOImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String dayBirth = req.getParameter("day");
        String monthBirth = req.getParameter("month");
        String yearBirth = req.getParameter("year");
        String gender = req.getParameter("gender");
        Gender genderEnum = Gender.valueOf(gender.toUpperCase());

        LocalDate dob = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
        String birthday = yearBirth + "-" + monthBirth + "-" + dayBirth;
        dob = LocalDate.parse(birthday, formatter);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setDob(dob);
        user.setGender(genderEnum);

        userDAO.save(user);

        req.setAttribute("message", "Đăng ký thành công!");
        req.getRequestDispatcher("/views/success.jsp").forward(req, resp);
    }
}
