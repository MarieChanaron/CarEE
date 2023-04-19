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
        System.out.println("in delete category GET method");
        String categoryId = request.getParameter("id");
        System.out.println(categoryId);
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
