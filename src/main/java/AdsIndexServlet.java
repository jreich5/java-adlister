import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdsIndexServlet", urlPatterns = "/ads")
public class AdsIndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("font-color") == null || request.getSession().getAttribute("background-color") == null) {
            response.sendRedirect("/color-profile");
        } else {
            System.out.println(request.getSession().getAttribute("background-color"));
            request.setAttribute("ads", DaoFactory.getAdsDao().all());
            request.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(request, response);
        }
    }
}
