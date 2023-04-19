package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CarDao;
import fr.mariech.voitures.model.Car;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "GetDetailsServlet", value = "/get-details")
public class GetDetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carId = request.getParameter("id");
        System.out.println(carId);
        CarDao carDao = new CarDao();
        Car car = carDao.fetchOneCar(carId);
        System.out.println(car);
        HttpSession session = request.getSession();
        session.setAttribute("thisCar", car);
        response.sendRedirect("/details-car");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
