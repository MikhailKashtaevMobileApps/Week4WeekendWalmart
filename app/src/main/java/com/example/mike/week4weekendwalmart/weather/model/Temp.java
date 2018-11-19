package com.example.mike.week4weekendwalmart.weather.model;

public class Temp {

    int deg;
    int sky; // 0=clear;  1=kinda cloudy, 2=superCloudy
    int time;

    public Temp(int deg, int sky, int time) {
        this.deg = deg;
        this.sky = sky;
        this.time = time;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getSky() {
        return sky;
    }

    public void setSky(int sky) {
        this.sky = sky;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Temp{" +
                "deg=" + deg +
                ", sky=" + sky +
                ", time=" + time +
                '}';
    }
}
