package me.zilzustudy.user;

import lombok.Getter;

@Getter
public class Geo {
    private String lat;
    private String lng;

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    public Geo() {
    }
}
