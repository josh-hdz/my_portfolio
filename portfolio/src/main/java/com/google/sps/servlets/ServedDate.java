package com.google.sps.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/** Servlet that responds with the current date. */
@WebServlet("/date")
public class ServedDate extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Date date = Calendar.getInstance().getTime();
    DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy");

    response.setContentType("text/html;");
    response.getWriter().println(formatter.format(date));
  }
}