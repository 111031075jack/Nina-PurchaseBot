package com.purchasebot.reader;


import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.purchasebot.model.CategoryRule;



public class CategoryRuleReader {


    public List<CategoryRule> readExcel(String path)
            throws Exception {


        List<CategoryRule> rules =
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


            if(row == null)
                continue;



            CategoryRule rule =
                    new CategoryRule();



            rule.setKeyword(
                    getCellValue(row.getCell(0))
            );


            rule.setType(
                    getCellValue(row.getCell(1))
            );


            rule.setBigCategory(
                    getCellValue(row.getCell(2))
            );


            rule.setMiddleCategory(
                    getCellValue(row.getCell(3))
            );


            rules.add(rule);


        }


        workbook.close();
        fis.close();


        return rules;

    }




    private String getCellValue(Cell cell){


        if(cell == null){
            return "";
        }


        switch(cell.getCellType()){


            case STRING:
                return cell.getStringCellValue();


            case NUMERIC:
                return String.valueOf(
                    cell.getNumericCellValue()
                );


            default:
                return "";

        }

    }


}