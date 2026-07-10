//package com.purchasebot;
//
//import com.purchasebot.model.PurchaseItem;
//
//public class PurchaseMapper {
//
//
//    public static MesItem convert(PurchaseItem item){
//
//
//        MesItem mes = new MesItem();
//
//
//        // Excel品名 -> MES品項名稱
//        mes.setItemName(
//                item.getProductName()
//        );
//
//
//        // 品項全名先跟名稱一樣
//        mes.setFullName(
//                item.getProductName()
//        );
//
//
//        // 單位
//        mes.setUnit(
//                item.getUnit()
//        );
//
//
//        // 價格
//        mes.setPrice(
//                item.getPriceWithTax()
//        );
//
//
//        // 暫時固定
//        mes.setItemType("生產原料");
//
//
//        // 其他先空白
//        mes.setSpecification("");
//
//        mes.setTemperature("");
//
//        mes.setMainCategory("");
//
//        mes.setMiddleCategory("");
//
//        mes.setSmallCategory("");
//
//
//        return mes;
//
//    }
//
//}