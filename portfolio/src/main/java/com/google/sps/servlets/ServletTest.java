package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Handles requests sent to the /servlet-test URL. Try running a server and navigating to /server-test */
@WebServlet("/servlet-test")
public class ServletTest extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>It works!</h1>");
    response.getWriter().println("<h2>It REALLY works!</h2>");
  }
}
