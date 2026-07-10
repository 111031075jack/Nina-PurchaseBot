package com.purchasebot.reader;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.purchasebot.model.PurchaseItem;



public class ExcelReader {


    public List<PurchaseItem> readExcel(String path)
            throws Exception {


        List<PurchaseItem> list =
                new ArrayList<>();


        FileInputStream fis =
                new FileInputStream(path);


        Workbook workbook =
                new XSSFWorkbook(fis);


        Sheet sheet =
                workbook.getSheetAt(0);



        for(int i = 1; i <= sheet.getLastRowNum(); i++){


            Row row =
                    sheet.getRow(i);


            if(row == null || isEmptyRow(row))
                continue;

            PurchaseItem item =
                    new PurchaseItem();



            // 廠商
            item.setSupplier(
                    getCellValue(row.getCell(0))
            );



            // 品名
            item.setProductName(
                    getCellValue(row.getCell(1))
            );



            // 數量
            item.setQuantity(
                    getDoubleValue(row.getCell(2))
            );



            // 單位
            item.setUnit(
                    getCellValue(row.getCell(3))
            );



            // 單價
            item.setPrice(
                    getDoubleValue(row.getCell(4))
            );



            // ⭐ 單價(含) 第7欄
            item.setPriceWithTax(
                    getDoubleValue(row.getCell(6))
            );



            list.add(item);

        }



        workbook.close();
        fis.close();



        return list;

    }




    private String getCellValue(Cell cell){


        if(cell == null)
            return "";



        switch(cell.getCellType()){


            case STRING:
                return cell.getStringCellValue();



            case NUMERIC:
                return String.valueOf(
                        cell.getNumericCellValue()
                );



            case BOOLEAN:
                return String.valueOf(
                        cell.getBooleanCellValue()
                );



            case FORMULA:
                return cell.toString();



            default:
                return "";

        }

    }





    private double getDoubleValue(Cell cell){


        String value =
                getCellValue(cell);



        if(value == null ||
                value.trim().isEmpty()){


            return 0;

        }



        return Double.parseDouble(value);

    }
    private boolean isEmptyRow(Row row){


        for(Cell cell : row){


            String value =
                    getCellValue(cell);


            if(value != null &&
               !value.trim().isEmpty()){


                return false;

            }

        }


        return true;

    }
}