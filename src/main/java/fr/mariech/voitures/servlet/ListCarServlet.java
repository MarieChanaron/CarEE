package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CarDao;
import fr.mariech.voitures.model.Car;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCarServlet", value = "/list-cars")
public class ListCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("cars") == null) {
            System.out.println("In list-car servlet");
            CarDao carDao = new CarDao();
            List<Car> cars = carDao.fetchCars();
            System.out.println(cars);
            session.setAttribute("cars", cars);
            request.getRequestDispatcher("/WEB-INF/list-cars/").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
