package main.java.org.gradle.demo;

import main.java.DBConnector;
import main.java.YeetUpUser;

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
        int subscriber = request.getParameter("subscribe")==null?0:1;

        System.out.println(forename + " " + surname + " " + email + " " + subscriber);

        if (forename == null || surname == null || email == null || password == null) {
            System.out.println("something is null");
            request.getRequestDispatcher("signup-fail.jsp").forward(request, response);
            return;
        }

        request.setAttribute("first-name", forename);
        request.setAttribute("last-name", surname);

        YeetUpUser user = new YeetUpUser(forename, surname, email, password, subscriber);

        boolean success = DBConnector.addUser(user);

        if (success == false) {
            request.getRequestDispatcher("signup-fail.jsp").forward(request, response);
            return;
        }

        request.getRequestDispatcher("signedup.jsp").forward(request, response);
    }

}
