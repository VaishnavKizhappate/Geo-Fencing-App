package com.example.geofencing;

public class Rescuedatamodel {


    private String district,area,name,contact;


    public Rescuedatamodel( String district, String area, String name,String contact){

        this.district=district;
        this.area=area;
        this.name=name;
        this.contact=contact;

    }


    public String getDistrict(){return district;}
    public String getArea(){return area;}
    public String getName(){return name;}
    public String getContact(){return contact;}
    }






