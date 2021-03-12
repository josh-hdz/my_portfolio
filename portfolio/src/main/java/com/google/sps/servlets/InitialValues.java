package com.google.sps.servlets;

import com.google.gson.Gson;
import com.google.sps.data.GoogleMap;
import com.google.sps.data.HeaderInfo;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/** 
 * Servlet handles info needed for header (greeting & date)
 * */
@WebServlet("/initial-values")
public class InitialValues extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Gson converter = new Gson();
        String headerInfo = converter.toJson(new HeaderInfo(5));
        String mapInfo = converter.toJson(new GoogleMap());

        response.setContentType("application/json;");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println('['+headerInfo+','+mapInfo+']');
    }
}