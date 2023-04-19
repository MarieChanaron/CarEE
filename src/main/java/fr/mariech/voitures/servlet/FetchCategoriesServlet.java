package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CategoryDao;
import fr.mariech.voitures.model.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FetchCategoriesServlet", value = "/fetch-categories")
public class FetchCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("fetching categories");
        HttpSession session = request.getSession();
        if (session.getAttribute("categories") == null) {
            CategoryDao categoryDao = new CategoryDao();
            List<Category> categories = categoryDao.fetchCategories();
            System.out.println(categories);
            session.setAttribute("categories", categories);
        }
    }

}
