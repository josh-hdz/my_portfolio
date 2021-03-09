package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/map-credential")
public class MapCredential extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String key = System.getenv("GOOGLE_MAPS_API_KEY");

        response.setContentType("text/html");
        response.getWriter().print(key);
    }
}