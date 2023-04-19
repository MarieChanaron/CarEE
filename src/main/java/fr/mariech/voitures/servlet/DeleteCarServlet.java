package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CarDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCarServlet", value = "/delete-car")
public class DeleteCarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("id");
        CarDao carDao = new CarDao();
        carDao.deleteCar(carId);
        HttpSession session = request.getSession();
        session.removeAttribute("cars");
        response.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
