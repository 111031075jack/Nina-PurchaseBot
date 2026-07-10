package com.purchasebot.model;


public class PurchaseItem {


    private String supplier;

    private String productName;

    private double quantity;

    private String unit;

    private double price;


    // 新增：含稅價格
    private double priceWithTax;



    public String getSupplier() {
        return supplier;
    }


    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }



    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }



    public double getQuantity() {
        return quantity;
    }


    public void setQuantity(double quantity) {
        this.quantity = quantity;
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



    public double getPriceWithTax() {
        return priceWithTax;
    }


    public void setPriceWithTax(double priceWithTax) {
        this.priceWithTax = priceWithTax;
    }

}