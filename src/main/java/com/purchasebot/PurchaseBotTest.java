package com.purchasebot;


import java.util.List;


public class PurchaseBotTest {


    public static void main(String[] args) {


        String path =
        "C:\\Users\\Owner\\Desktop\\採購單價-提供查詢.xlsx";



        List<PurchaseItem> list =
                ExcelReader.readExcel(path);



        PurchaseBotGUI gui =
                new PurchaseBotGUI(list);



        gui.setVisible(true);


    }

}