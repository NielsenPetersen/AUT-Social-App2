package com.example.user1.socialappaut;


public class Event_Items {

    private String Event;
    private String Date;
    private String Time;
    private String Description;
    private String Image;


    public Event_Items() {

    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public Event_Items(String event, String date, String time, String description, String image) {

        Event = event;
        Date = date;
        Time = time;
        Description = description;
        Image = image;

    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

}
