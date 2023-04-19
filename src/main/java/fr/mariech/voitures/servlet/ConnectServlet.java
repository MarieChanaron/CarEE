package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.AdminDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ConnectServlet", value = "/connect")
public class ConnectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        AdminDao adminDao = new AdminDao();
        if (adminDao.checkCredentials(login, password)) {
            HttpSession session = request.getSession();
            session.setAttribute("logged", true);
            response.sendRedirect("/home");
        } else {
            response.sendRedirect("/login?login=false");
        }
    }
}
