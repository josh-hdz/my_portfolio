package com.google.sps.data;

import java.util.ArrayList;

/**
 * Object contains all needed data for Google map.
 */
public class GoogleMap {

    final String apiKey;
    ArrayList<Marker> markers;

    public GoogleMap(){

        this.apiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        this.markers = new ArrayList<Marker>();

        this.markers.add(new Marker("Chihuahua, Chih", 28.6709132, -106.1346578));
        this.markers.add(new Marker("Juarez, Chih", 31.6538753, -106.5189751));
        this.markers.add(new Marker("Monterrey, N.L.", 25.6487782, -100.3731359));
        this.markers.add(new Marker("Santa Catarina, N.L.", 25.6845256, -100.5235758));
        this.markers.add(new Marker("Guadalupe, N.L.", 25.6766854, -100.2351512));
        this.markers.add(new Marker("San Nicolas, N.L.", 25.7358827, -100.3052989));
        this.markers.add(new Marker("San Ramon, Ca", 37.7581036, -121.9756271));
        this.markers.add(new Marker("Guadalajara, Jal", 20.6737883, -103.3704326));


    }

    public String getApiKey(){
        return apiKey;
    }

    public ArrayList<Marker> getMarkers(){
        return markers;
    }
}