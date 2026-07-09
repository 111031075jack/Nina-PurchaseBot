package com.purchasebot;

import lombok.Data;

@Data
public class MesItem {


    // 品項類型
    private String itemType;


    // 品項名稱
    private String itemName;


    // 品項全名
    private String fullName;


    // 品項規格
    private String specification;


    // 保存溫層
    private String temperature;


    // 大分類
    private String mainCategory;


    // 中分類
    private String middleCategory;


    // 小分類
    private String smallCategory;


    // 採購單位
    private String unit;


    // 初次報價
    private double price;


}