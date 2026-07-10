package com.purchasebot.model;


public class UnclassifiedItem {


    private String fullName;   //原始品名

    private String name;       //整理後品名

    private String unit;       //單位

    private double price;      //價格



    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }



    public String getUnit() {
        return unit;
    }


    public void setUnit(String unit) {
        this.unit = unit;
    }



    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;
    }

}