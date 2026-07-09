package com.purchasebot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelReader {


    public static List<PurchaseItem> readExcel(String path) {


        List<PurchaseItem> list = new ArrayList<>();


        try {


            FileInputStream fis = new FileInputStream(path);

            Workbook workbook = new XSSFWorkbook(fis);


            Sheet sheet = workbook.getSheetAt(0);


            // 第0列是標題
            // 從第1列開始讀資料
            for(int i = 1; i <= sheet.getLastRowNum(); i++) {


                Row row = sheet.getRow(i);


                if(row == null) {
                    continue;
                }


                PurchaseItem item = new PurchaseItem();



                // 廠商
                item.setSupplier(
                        getString(row.getCell(0))
                );


                // 品名
                item.setProductName(
                        getString(row.getCell(1))
                );


                // 數量
                item.setQuantity(
                        (int)getNumber(row.getCell(2))
                );


                // 單位
                item.setUnit(
                        getString(row.getCell(3))
                );


                // 單價
                item.setUnitPrice(
                        getNumber(row.getCell(4))
                );


                // 小計
                item.setSubtotal(
                        getNumber(row.getCell(5))
                );


                // 單價(含)
                item.setPriceWithTax(
                        getNumber(row.getCell(6))
                );


                // 折扣
                item.setDiscount(
                        getNumber(row.getCell(7))
                );


                // 稅額
                item.setTax(
                        getNumber(row.getCell(8))
                );


                // 列總計
                item.setTotal(
                        getNumber(row.getCell(9))
                );


                // 訂購日期
                item.setOrderDate(
                        getString(row.getCell(10))
                );



                list.add(item);



                // 每500筆提示一次
                if(list.size() % 500 == 0) {

                    System.out.println(
                            "已讀取：" + list.size() + "筆"
                    );

                }


            }


            workbook.close();
            fis.close();



        } catch(Exception e) {

            e.printStackTrace();

        }



        return list;

    }





    /**
     * 讀取文字欄位
     */
    private static String getString(Cell cell) {


        if(cell == null) {

            return "";

        }



        switch(cell.getCellType()) {


            case STRING:

                return cell.getStringCellValue();



            case NUMERIC:

                return String.valueOf(
                        cell.getNumericCellValue()
                );



            case ERROR:

                return "";



            case BLANK:

                return "";



            default:

                return "";

        }


    }





    /**
     * 讀取數字欄位
     */
    private static double getNumber(Cell cell) {


        if(cell == null) {

            return 0;

        }



        switch(cell.getCellType()) {


            case NUMERIC:

                return cell.getNumericCellValue();



            case STRING:

                try {

                    return Double.parseDouble(
                            cell.getStringCellValue()
                    );

                } catch(Exception e) {

                    return 0;

                }



            case ERROR:

                return 0;



            default:

                return 0;

        }


    }


}