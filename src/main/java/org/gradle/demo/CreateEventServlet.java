package main.java.org.gradle.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateEventServlet", urlPatterns = {"event-creation"}, loadOnStartup = 1)
public class CreateEventServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("event_name");
        String date = request.getParameter("date");
        String time = request.getParameter("time");
        String location = request.getParameter("location");
        // TODO need to add user_id when log-in works, for now it will be 999
        int user_id = 999;

        if (location == null || name == null || date == null || time == null) {
            request.getRequestDispatcher("event-fail.jsp").forward(request, response);
            return;
        }
        request.setAttribute("user", name);
        request.getRequestDispatcher("response.jsp").forward(request, response);
    }
}
