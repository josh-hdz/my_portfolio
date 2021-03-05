package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    // Get the value entered in the form.
    String reason = request.getParameter("reason");
    String description = request.getParameter("description");

    // Print the value so you can see it in the server logs.
    System.out.println("FORM RECIVED");
    System.out.println(reason + ": " + description);

    response.sendRedirect("https://jhernandez-sps-spring21.appspot.com");
  }
}