package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");

        if (name == null) {
            name = "World!";
        } else if (name.equals("bgates")) {
            response.sendRedirect("https://microsoft.com");
            return;
        }

        request.setAttribute("user", name);
        request.getRequestDispatcher("/hello.jsp").forward(request, response);

    }
}
