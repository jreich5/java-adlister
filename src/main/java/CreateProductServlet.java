import interfaces.Products;
import models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/create")
public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/products/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Products productsDao = DaoFactory.getProductsDao();

        // create a new product based on the submitted data
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        // persist the new product
        productsDao.insert(new Product(name, price));

        response.sendRedirect("/products");
    }
}