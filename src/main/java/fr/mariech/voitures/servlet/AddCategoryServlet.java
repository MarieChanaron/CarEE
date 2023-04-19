package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CarDao;
import fr.mariech.voitures.dbconnect.CategoryDao;
import fr.mariech.voitures.model.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", value = "/auth/add-category")
public class AddCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/add-category/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.insertCategory(name);
        HttpSession session = request.getSession();
        session.removeAttribute("categories");
        response.sendRedirect("/list-category");
    }
}
