package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CarDao;
import fr.mariech.voitures.dbconnect.CategoryDao;
import fr.mariech.voitures.model.Car;
import fr.mariech.voitures.model.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListCategoryServlet", value = "/list-category")
public class ListCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in list category servlet");
        request.getRequestDispatcher("/WEB-INF/categories/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
