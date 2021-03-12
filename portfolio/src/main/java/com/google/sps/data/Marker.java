package com.google.sps.data;


/**
 * Object contains all needed data for a google map's marker.
 */
public final class Marker{
    private final String label;
    private final double latitude;
    private final double longitude;

    public Marker(String label, double latitude, double longitude){
        this.label = label;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLabel(){
        return this.label;
    }

    public double getLatitude(){
        return latitude;
    }

    public double getLongitude(){
        return longitude;
    }
}