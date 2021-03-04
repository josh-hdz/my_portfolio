package com.google.sps.servlets;

import com.google.gson.Gson;
import com.google.sps.data.HeaderInfo;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** Servlet handles info needed for header (greeting & date) */
@WebServlet("/header-handler")
public class HeaderHandler extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson converter = new Gson();
        HeaderInfo headerInfo = new HeaderInfo(5);
        String json = converter.toJson(headerInfo);
        

        response.setContentType("application/json;");
        response.getWriter().println(json);
    }
}