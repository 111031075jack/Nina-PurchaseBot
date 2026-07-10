package com.purchasebot.writer;


import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.purchasebot.model.UnclassifiedItem;



public class UnclassifiedExcelWriter {



    public void write(
            List<UnclassifiedItem> list,
            String path
    ) throws Exception {



        Workbook workbook =
                new XSSFWorkbook();



        Sheet sheet =
                workbook.createSheet("未分類商品");



        //標題

        Row header =
                sheet.createRow(0);


        header.createCell(0)
              .setCellValue("品項全名");


        header.createCell(1)
              .setCellValue("品項名稱");


        header.createCell(2)
              .setCellValue("單位");


        header.createCell(3)
              .setCellValue("價格");




        int rowIndex = 1;



        for(UnclassifiedItem item : list){


            Row row =
                    sheet.createRow(rowIndex++);



            row.createCell(0)
               .setCellValue(
                    item.getFullName()
               );


            row.createCell(1)
               .setCellValue(
                    item.getName()
               );


            row.createCell(2)
               .setCellValue(
                    item.getUnit()
               );


            row.createCell(3)
               .setCellValue(
                    item.getPrice()
               );


        }



        workbook.write(
                new FileOutputStream(path)
        );


        workbook.close();



    }


}