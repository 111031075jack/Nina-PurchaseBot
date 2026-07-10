package com.purchasebot.model;


public class ProductMaster {

    private String type;              //品項類型

    private String name;              //品項名稱

    private String fullName;          //品項全名

    private String spec;              //品項規格

    private String description;       //品項說明

    private String storageTemp;       //保存溫層


    private String bigCategory;       //大分類

    private String middleCategory;    //中分類

    private String smallCategory;     //小分類


    private String purchaseUnit;      //採購單位

    private String convertUnit;       //轉換單位


    private double firstPrice;        //初次報價



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getStorageTemp() {
        return storageTemp;
    }

    public void setStorageTemp(String storageTemp) {
        this.storageTemp = storageTemp;
    }


    public String getBigCategory() {
        return bigCategory;
    }

    public void setBigCategory(String bigCategory) {
        this.bigCategory = bigCategory;
    }


    public String getMiddleCategory() {
        return middleCategory;
    }

    public void setMiddleCategory(String middleCategory) {
        this.middleCategory = middleCategory;
    }


    public String getSmallCategory() {
        return smallCategory;
    }

    public void setSmallCategory(String smallCategory) {
        this.smallCategory = smallCategory;
    }


    public String getPurchaseUnit() {
        return purchaseUnit;
    }

    public void setPurchaseUnit(String purchaseUnit) {
        this.purchaseUnit = purchaseUnit;
    }


    public String getConvertUnit() {
        return convertUnit;
    }

    public void setConvertUnit(String convertUnit) {
        this.convertUnit = convertUnit;
    }


    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }



    @Override
    public String toString(){

        return 
        "類型:" + type +
        " | 名稱:" + name +
        " | 全名:" + fullName +
        " | 規格:" + spec +
        " | 溫層:" + storageTemp +
        " | 大分類:" + bigCategory +
        " | 中分類:" + middleCategory +
        " | 小分類:" + smallCategory +
        " | 單位:" + purchaseUnit +
        " | 報價:" + firstPrice;

    }

}