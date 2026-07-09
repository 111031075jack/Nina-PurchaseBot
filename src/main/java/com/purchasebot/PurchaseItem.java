package com.purchasebot;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

    private String supplier;      // 廠商
    private String productName;   // 品名
    private int quantity;         // 數量
    private String unit;          // 單位

    private double unitPrice;     
    private double subtotal;      
    private double priceWithTax;  
    private double discount;      
    private double tax;           
    private double total;         

    private String orderDate;

}