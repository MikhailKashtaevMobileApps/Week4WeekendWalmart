package com.example.mike.week4weekendwalmart.weather;

import com.example.mike.week4weekendwalmart.weather.model.Temp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WeatherGenerator {

    public static List<Temp> getWeather(  ){

        String dateFormat = "MMddHH";
        Date dt = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String seed = format.format(dt);

        Random rnd = new Random(Long.valueOf(seed));

        ArrayList<Temp> temperatures = new ArrayList<>();

        for (int i = 0; i < 24; i++) {
            temperatures.add(new Temp(
                    rnd.nextInt(30),
                    rnd.nextInt(3),
                    i
            ));
        }

        return temperatures;
    }

    public static List<Temp> filterToday( List<Temp> t ){

        String dateFormat = "MMddHH";
        Date dt = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        String seed = format.format(dt);

        return t.subList(Integer.valueOf( seed.substring(4) ), t.size());
    }

}
