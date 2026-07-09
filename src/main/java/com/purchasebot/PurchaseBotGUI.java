package com.purchasebot;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PurchaseBotGUI extends JFrame {


    private List<PurchaseItem> items;


    private int index = 0;



    private JLabel supplierLabel;
    private JLabel productLabel;
    private JLabel quantityLabel;
    private JLabel unitLabel;
    private JLabel priceLabel;
    private JLabel dateLabel;



    public PurchaseBotGUI(List<PurchaseItem> items) {


        this.items = items;



        setTitle("採購資料瀏覽工具");


        setSize(500,400);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setLocationRelativeTo(null);



        JPanel centerPanel = new JPanel(
                new GridLayout(6,2)
        );



        centerPanel.add(new JLabel("廠商"));

        supplierLabel = new JLabel();

        centerPanel.add(supplierLabel);



        centerPanel.add(new JLabel("品名"));

        productLabel = new JLabel();

        centerPanel.add(productLabel);



        centerPanel.add(new JLabel("數量"));

        quantityLabel = new JLabel();

        centerPanel.add(quantityLabel);



        centerPanel.add(new JLabel("單位"));

        unitLabel = new JLabel();

        centerPanel.add(unitLabel);



        centerPanel.add(new JLabel("價格"));

        priceLabel = new JLabel();

        centerPanel.add(priceLabel);



        centerPanel.add(new JLabel("日期"));

        dateLabel = new JLabel();

        centerPanel.add(dateLabel);



        add(centerPanel, BorderLayout.CENTER);




        JButton prevButton =
                new JButton("上一筆");



        JButton nextButton =
                new JButton("下一筆");



        JPanel bottom =
                new JPanel();



        bottom.add(prevButton);

        bottom.add(nextButton);



        add(bottom, BorderLayout.SOUTH);




        prevButton.addActionListener(e -> {


            if(index > 0){

                index--;

                showData();

            }


        });




        nextButton.addActionListener(e -> {


            if(index < items.size()-1){

                index++;

                showData();

            }


        });



        showData();


    }




    private void showData(){


        PurchaseItem item =
                items.get(index);



        supplierLabel.setText(
                item.getSupplier()
        );



        productLabel.setText(
                item.getProductName()
        );



        quantityLabel.setText(
                String.valueOf(
                        item.getQuantity()
                )
        );



        unitLabel.setText(
                item.getUnit()
        );



        priceLabel.setText(
                String.valueOf(
                        item.getTotal()
                )
        );



        dateLabel.setText(
                item.getOrderDate()
        );



        setTitle(
                "採購資料瀏覽工具  "
                +(index+1)
                +"/"
                +items.size()
        );


    }



}