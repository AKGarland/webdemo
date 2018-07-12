package site.servlets;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EventListServlet", urlPatterns = {"events"}, loadOnStartup = 1)
public class EventListServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");

        if (name == null) name = "World";

        request.setAttribute("user", name);

        request.getRequestDispatcher("events.jsp").forward(request, response);
    }
}
