//package com.purchasebot.test;
//
//
//import java.util.List;
//
//import com.purchasebot.model.CategoryRule;
//import com.purchasebot.model.PurchaseItem;
//import com.purchasebot.reader.CategoryRuleReader;
//import com.purchasebot.reader.ExcelReader;
//import com.purchasebot.service.CategoryService;
//
//
//public class CategoryTest {
//
//
//    public static void main(String[] args) throws Exception {
//
//
//        // MES商品Excel路徑
//        String productPath =
//                "C:\\Users\\Owner\\Desktop\\MES商品主檔.xlsx";
//
//
//        // 分類規則Excel路徑
//        String rulePath =
//                "C:\\Users\\Owner\\Desktop\\CategoryRule.xlsx";
//
//
//
//        ExcelReader excelReader =
//                new ExcelReader();
//
//
//        CategoryRuleReader ruleReader =
//                new CategoryRuleReader();
//
//
//
//        List<PurchaseItem> items =
//                excelReader.readExcel(productPath);
//
//
//
//        List<CategoryRule> rules =
//                ruleReader.readExcel(rulePath);
//
//
//
//        CategoryService service =
//                new CategoryService();
//
//
//
//        for(PurchaseItem item : items) {
//
//
//            CategoryRule rule =
//                    service.classify(
//                            item.getProductName(),
//                            rules
//                    );
//
//
//
//            if(rule != null) {
//
//
//                item.setCategory(
//                        rule.getType()
//                );
//
//
//                item.setBigCategory(
//                        rule.getBigCategory()
//                );
//
//
//                item.setMiddleCategory(
//                        rule.getMiddleCategory()
//                );
//
//
//            }
//            else {
//
//
//                item.setCategory("其他");
//
//
//            }
//
//
//
//            System.out.println(
//                    item.getProductName()
//                    +
//                    " → "
//                    +
//                    item.getCategory()
//                    +
//                    " / "
//                    +
//                    item.getBigCategory()
//                    +
//                    " / "
//                    +
//                    item.getMiddleCategory()
//            );
//
//
//        }
//
//
//    }
//
//
//}