package com.purchasebot.service;


import java.util.List;

import com.purchasebot.model.CategoryRule;
import com.purchasebot.model.ProductMaster;
import com.purchasebot.model.PurchaseItem;



public class ProductClassifier {



    private List<CategoryRule> rules;



    public ProductClassifier(List<CategoryRule> rules){


        rules.sort(
            (a,b) ->
                Integer.compare(
                    a.getPriority(),
                    b.getPriority()
                )
        );


        this.rules = rules;

    }





    public ProductMaster classify(PurchaseItem item){



        ProductMaster product =
                new ProductMaster();



        String productName =
                item.getProductName();



        // 品項全名

        product.setFullName(
                productName
        );



        String name =
                productName;



     // 去除品牌符號

        if(name.startsWith("(")){

            int index = name.indexOf(")");

            if(index != -1){
                name = name.substring(index + 1);
            }

        }


        if(name.startsWith("【")){

            int index = name.indexOf("】");

            if(index != -1){
                name = name.substring(index + 1);
            }

        }


        if(name.startsWith("*私版*")){

            name = name.substring(4);

        }



        // 拆規格


        String spec = "";



        if(name.matches(".*\\d+.*")){


            int index =
                    name.indexOf("1KG");



            if(index != -1){


                spec =
                name.substring(index);



                name =
                name.substring(0,index);

            }

        }




        product.setName(name);


        product.setSpec(spec);





        // =====================
        // Excel規則分類
        // =====================


        for(CategoryRule rule : rules){



            if(name.contains(rule.getKeyword())){


                product.setType(
                        rule.getType()
                );


                product.setBigCategory(
                        rule.getBigCategory()
                );


                product.setMiddleCategory(
                        rule.getMiddleCategory()
                );


                break;

            }

        }





        // 沒分類

        if(product.getType() == null){


            product.setType("其他");


            product.setBigCategory("其他");


            product.setMiddleCategory("其他");

        }






        // 小分類

        if(productName.contains("進口")){


            product.setSmallCategory(
                    "進口"
            );


        }else{


            product.setSmallCategory(
                    "國產"
            );

        }






        // 保存溫層


        if(productName.contains("冷凍")){


            product.setStorageTemp(
                    "冷凍"
            );


        }else{


            product.setStorageTemp(
                    "涼場"
            );

        }





        // 單位


        product.setPurchaseUnit(
                item.getUnit()
        );


        product.setConvertUnit(
                item.getUnit()
        );






        // ⭐ 初次報價使用含稅價格

        product.setFirstPrice(
                item.getPriceWithTax()
        );





        return product;


    }



}