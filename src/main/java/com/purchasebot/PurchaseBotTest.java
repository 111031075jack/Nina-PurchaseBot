package com.purchasebot;


import java.util.ArrayList;
import java.util.List;



public class PurchaseBotTest {


    public static void main(String[] args) {



        String path =
                "C:\\Users\\Owner\\Desktop\\採購單價-提供查詢.xlsx";



        // 1. 讀取 Excel

        List<PurchaseItem> purchaseList =
                ExcelReader.readExcel(path);



        System.out.println(
                "Excel資料筆數:"
                + purchaseList.size()
        );




        // 2. PurchaseItem 轉 MesItem

        List<MesItem> mesList =
                new ArrayList<>();



        for(PurchaseItem item : purchaseList){


            MesItem mes =
                    PurchaseMapper.convert(item);



            mesList.add(mes);


        }





        System.out.println(
                "MES資料筆數:"
                + mesList.size()
        );





        // 3. 測試第一筆資料


        MesItem first =
                mesList.get(0);



        System.out.println("=================");


        System.out.println(
                "品項類型:"
                + first.getItemType()
        );


        System.out.println(
                "品項名稱:"
                + first.getItemName()
        );


        System.out.println(
                "採購單位:"
                + first.getUnit()
        );


        System.out.println(
                "初次報價:"
                + first.getPrice()
        );


        System.out.println("=================");






        // 4. 開啟GUI


        PurchaseBotGUI gui =
                new PurchaseBotGUI(mesList);



        gui.setVisible(true);



    }


}