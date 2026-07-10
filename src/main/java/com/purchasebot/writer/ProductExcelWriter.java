package com.purchasebot.writer;


import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.purchasebot.model.ProductMaster;



public class ProductExcelWriter {



    public void write(
            List<ProductMaster> products,
            String path)
            throws Exception {



        Workbook workbook =
                new XSSFWorkbook();



        Sheet sheet =
                workbook.createSheet(
                        "商品主檔"
                );




        Row header =
                sheet.createRow(0);



        String[] titles = {


            "品項類型",
            "品項名稱",
            "品項全名",
            "品項規格",
            "品項說明",
            "保存溫層",
            "大分類",
            "中分類",
            "小分類",
            "採購單位",
            "轉換單位",
            "初次報價"

        };




        for(int i=0;i<titles.length;i++){


            header.createCell(i)
                  .setCellValue(
                          titles[i]
                  );

        }







        int rowIndex = 1;



        for(ProductMaster product : products){



            Row row =
                    sheet.createRow(
                            rowIndex++
                    );



            row.createCell(0)
               .setCellValue(
                    product.getType()
               );


            row.createCell(1)
               .setCellValue(
                    product.getName()
               );


            row.createCell(2)
               .setCellValue(
                    product.getFullName()
               );


            row.createCell(3)
               .setCellValue(
                    product.getSpec()
               );


            row.createCell(4)
               .setCellValue(
                    product.getDescription()
               );


            row.createCell(5)
               .setCellValue(
                    product.getStorageTemp()
               );


            row.createCell(6)
               .setCellValue(
                    product.getBigCategory()
               );


            row.createCell(7)
               .setCellValue(
                    product.getMiddleCategory()
               );


            row.createCell(8)
               .setCellValue(
                    product.getSmallCategory()
               );


            row.createCell(9)
               .setCellValue(
                    product.getPurchaseUnit()
               );


            row.createCell(10)
               .setCellValue(
                    product.getConvertUnit()
               );


            row.createCell(11)
               .setCellValue(
                    product.getFirstPrice()
               );


        }





        for(int i=0;i<titles.length;i++){

            sheet.autoSizeColumn(i);

        }




        FileOutputStream fos =
                new FileOutputStream(path);



        workbook.write(fos);



        workbook.close();
        fos.close();


    }


}