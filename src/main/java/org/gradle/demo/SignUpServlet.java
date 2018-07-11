package main.java.org.gradle.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet", urlPatterns = {"sign-up"}, loadOnStartup = 1)
public class SignUpServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String forename = request.getParameter("forename");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String subscriber = request.getParameter("subscribe");

        if (forename == null || surname == null || email == null || password == null) {
            request.getRequestDispatcher("event-fail.jsp").forward(request, response);
            return;
        }

        request.setAttribute("first-name", forename);
        request.setAttribute("last-name", surname);
        request.setAttribute("email-address", email);
        request.setAttribute("password", password);
        request.setAttribute("subscriber", subscriber);

        request.getRequestDispatcher("response.jsp").forward(request, response);
    }

}
