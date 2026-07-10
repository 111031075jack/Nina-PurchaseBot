package com.purchasebot;


import java.util.ArrayList;
import java.util.List;

import com.purchasebot.model.CategoryRule;
import com.purchasebot.model.ProductMaster;
import com.purchasebot.model.PurchaseItem;
import com.purchasebot.reader.CategoryRuleReader;
import com.purchasebot.reader.ExcelReader;
import com.purchasebot.service.ProductClassifier;
import com.purchasebot.writer.ProductExcelWriter;
import com.purchasebot.model.UnclassifiedItem;
import com.purchasebot.writer.UnclassifiedExcelWriter;


public class Main {


    public static void main(String[] args)
            throws Exception {



        // ==========================
        // 1. 讀取採購資料 Excel
        // ==========================


        ExcelReader excelReader =
                new ExcelReader();


        List<PurchaseItem> items =
                excelReader.readExcel(
                "C:\\Users\\Owner\\Desktop\\採購單價-提供查詢.xlsx"
                );



        System.out.println(
                "採購資料筆數：" + items.size()
        );





        // ==========================
        // 2. 讀取分類規則 Excel
        // ==========================


        CategoryRuleReader ruleReader =
                new CategoryRuleReader();



        List<CategoryRule> rules =
                ruleReader.readExcel(
                "C:\\Users\\Owner\\Desktop\\CategoryRule.xlsx.xlsx"
                );



        System.out.println(
                "分類規則筆數：" + rules.size()
        );






        // ==========================
        // 3. 建立分類器
        // ==========================


        ProductClassifier classifier =
                new ProductClassifier(rules);







        // ==========================
        // 4. 開始分類全部商品
        // ==========================


        List<ProductMaster> products =
                new ArrayList<>();


        for(PurchaseItem item : items){


            ProductMaster product =
                    classifier.classify(item);


            products.add(product);


        }






        // ==========================
        // 5. 找未分類商品
        // ==========================


        int otherCount = 0;


        List<UnclassifiedItem> unclassified =
                new ArrayList<>();

        for(ProductMaster product : products){



        	if("其他".equals(product.getType())){


        	    otherCount++;



        	    UnclassifiedItem item =
        	            new UnclassifiedItem();



        	    item.setFullName(
        	            product.getFullName()
        	    );


        	    item.setName(
        	            product.getName()
        	    );


        	    item.setUnit(
        	            product.getPurchaseUnit()
        	    );


        	    item.setPrice(
        	            product.getFirstPrice()
        	    );


        	    unclassified.add(item);



        	}


        }





        System.out.println(
                "未分類數量：" 
                + otherCount
        );

        UnclassifiedExcelWriter unWriter =
                new UnclassifiedExcelWriter();


        unWriter.write(
                unclassified,
                "C:\\Users\\Owner\\Desktop\\未分類商品.xlsx"
        );


        System.out.println(
                "未分類Excel輸出完成"
        );




        // ==========================
        // 6. 輸出 MES 商品主檔
        // ==========================


        ProductExcelWriter writer =
                new ProductExcelWriter();



        writer.write(
                products,
                "C:\\Users\\Owner\\Desktop\\MES商品主檔.xlsx"
        );



        System.out.println(
                "Excel輸出完成"
        );


    }

}