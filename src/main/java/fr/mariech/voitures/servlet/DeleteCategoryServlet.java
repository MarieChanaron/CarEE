package fr.mariech.voitures.servlet;

import fr.mariech.voitures.dbconnect.CategoryDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCategoryServlet", value = "/delete-category")
public class DeleteCategoryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryId = request.getParameter("id");
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.deleteCategory(categoryId);
        HttpSession session = request.getSession();
        session.removeAttribute("categories");
        response.sendRedirect("/list-category");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
