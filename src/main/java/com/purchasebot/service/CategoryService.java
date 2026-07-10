package com.purchasebot.service;


import java.util.List;

import com.purchasebot.model.CategoryRule;


public class CategoryService {


    public CategoryRule classify(
            String productName,
            List<CategoryRule> rules) {


        for(CategoryRule rule : rules) {


            if(productName.contains(rule.getKeyword())) {

                return rule;

            }

        }


        return null;

    }

}