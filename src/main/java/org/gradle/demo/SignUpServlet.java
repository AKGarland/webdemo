package main.java.org.gradle.demo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "SignUpServlet", urlPatterns = {"sign-up"}, loadOnStartup = 1)
public class SignUpServlet extends HttpServlet {


}
