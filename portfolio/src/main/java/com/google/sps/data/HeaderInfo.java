package com.google.sps.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Random;

public final class HeaderInfo{

    private HashSet<String> chosenGreetings;
    private String todayDate;

    public HeaderInfo(int size) {
        this.setChosenGreetings(size);
        this.setTodayDate();
    }

    private void setChosenGreetings(int size) {
        Random randomizer = new Random();
        String[] greetings = new String[] {
            "Hello world",
            "¡Hola mundo",
            "Привет, мир",
            "Ciao mondo",
            "Bonjour le monde",
            "Talofa lalolagi",
            "Salut lume",
            "Hola món",
            "Orbis terrarum salve",
            "Olá mundo",
            "Halo dunia",
            "Ahoj dvet",
            "Halló heimur",
            "Zdravo svijete",
            "Hej världen"
        };

        this.chosenGreetings = new HashSet<String>();
        if(size > greetings.length) {
            size = greetings.length;
        }
        
        while(chosenGreetings.size() != size) {
            chosenGreetings.add(greetings[randomizer.nextInt(greetings.length)]);
        }
    }

    private void setTodayDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyyy");

        this.todayDate = formatter.format(date);
    }

    public HashSet<String> getChosenGreetings() {
        return this.chosenGreetings;
    }

    public String getTodayDate() {
        return this.todayDate;
    }
}