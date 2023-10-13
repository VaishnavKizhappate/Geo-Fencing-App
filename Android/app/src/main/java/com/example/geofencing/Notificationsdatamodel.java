package com.example.geofencing;

public class Notificationsdatamodel {



    private String title,notifications,date;


    public Notificationsdatamodel( String title, String notifications, String date){

this.title=title;
this.notifications=notifications;
this.date=date;

    }


    public String getTitle(){ return title; }
    public String getNotifications(){return notifications;}
    public String getDate(){return date;}


}
