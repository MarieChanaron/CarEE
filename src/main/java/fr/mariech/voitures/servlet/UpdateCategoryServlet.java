package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CategoryDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateCategoryServlet", value = "/update-category")
public class UpdateCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("id");
        String categoryName = request.getParameter("name");
        request.setAttribute("catId", categoryId);
        request.setAttribute("catName", categoryName);
        request.getRequestDispatcher("/WEB-INF/update-category/").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String newName = request.getParameter("name");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.updateCategory(id, newName);
        HttpSession session = request.getSession();
        session.removeAttribute("categories");
        session.removeAttribute("cars");
        response.sendRedirect("/list-category");
    }
}
