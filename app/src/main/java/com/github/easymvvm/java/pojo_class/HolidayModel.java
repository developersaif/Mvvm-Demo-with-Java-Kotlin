package com.github.easymvvm.java.pojo_class;


import java.io.Serializable;

public class HolidayModel implements Serializable {

    private String description;
    private String name;
    private String thumbnail;

    public String getDate() {
        return description;
    }

    public void setDate(String date) {
        this.description = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }



}
