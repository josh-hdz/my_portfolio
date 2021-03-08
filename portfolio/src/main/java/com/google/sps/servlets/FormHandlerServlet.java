package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

/* Servlet responsible for managing user's filled form*/
@WebServlet("/form-handler")
public class FormHandlerServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {


    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Comment");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set(
                "reason",
                Jsoup.clean(request.getParameter("reason"),Whitelist.none())
            )
            .set(
                "description",
                Jsoup.clean(request.getParameter("description"),Whitelist.none())
            )
            .set(
                "timestamp",
                System.currentTimeMillis()
            )
            .build();
    datastore.put(taskEntity);

    response.sendRedirect("/index.html");
  }
}