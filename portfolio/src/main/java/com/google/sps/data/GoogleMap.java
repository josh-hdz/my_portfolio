package com.google.sps.data;

import java.util.ArrayList;
import javax.servlet.http.HttpServlet;


public class GoogleMap extends HttpServlet {

    final String apiKey;
    ArrayList<Marker> markers;

    public GoogleMap(){

        String[] label = {
            "Chihuahua, Chih",
            "Juarez, Chih",
            "Monterrey, N.L.",
            "Santa Catarina, N.L.",
            "Guadalupe, N.L.",
            "San Nicolas, N.L.",
            "San Ramon, Ca",
            "Guadalajara, Jal"
        };

        double[] lat = {
            28.6709132,
            31.6538753,
            16.3400499,
            25.6845256,
            27.3338167,
            25.7358827,
            37.7581036,
            20.6737883
        };

        double[] lng = {
            -106.1346578,
            -106.5189751,
            -85.7228682,
            -100.5235758,
            -107.7938329,
            -100.3052989,
            -121.9756271,
            -103.3704326
        };

        this.apiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        this.markers = new ArrayList<Marker>();

        for(int i = 0; i < label.length; i++){
            this.markers.add(new Marker(label[i], lat[i], lng[i]));
        }
    }

    public String getApiKey(){
        return apiKey;
    }

    public ArrayList<Marker> getMarkers(){
        return markers;
    }
}