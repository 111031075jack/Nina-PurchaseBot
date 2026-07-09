package com.purchasebot;


import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class PurchaseBotGUI extends JFrame {


    private List<MesItem> items;


    private int index = 0;



    private JLabel typeLabel;
    private JLabel nameLabel;
    private JLabel fullNameLabel;
    private JLabel specLabel;
    private JLabel tempLabel;
    private JLabel unitLabel;
    private JLabel priceLabel;



    public PurchaseBotGUI(List<MesItem> items) {


        this.items = items;



        setTitle("MES新增資料");


        setSize(600,450);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        setLocationRelativeTo(null);




        JPanel centerPanel =
                new JPanel(new GridLayout(7,2));



        // 品項類型

        centerPanel.add(
                new JLabel("品項類型")
        );

        typeLabel = new JLabel();

        centerPanel.add(typeLabel);



        // 品項名稱

        centerPanel.add(
                new JLabel("品項名稱")
        );

        nameLabel = new JLabel();

        centerPanel.add(nameLabel);



        // 品項全名

        centerPanel.add(
                new JLabel("品項全名")
        );

        fullNameLabel = new JLabel();

        centerPanel.add(fullNameLabel);



        // 品項規格

        centerPanel.add(
                new JLabel("品項規格")
        );

        specLabel = new JLabel();

        centerPanel.add(specLabel);



        // 保存溫層

        centerPanel.add(
                new JLabel("保存溫層")
        );

        tempLabel = new JLabel();

        centerPanel.add(tempLabel);



        // 採購單位

        centerPanel.add(
                new JLabel("採購單位")
        );

        unitLabel = new JLabel();

        centerPanel.add(unitLabel);



        // 初次報價

        centerPanel.add(
                new JLabel("初次報價")
        );

        priceLabel = new JLabel();

        centerPanel.add(priceLabel);



        add(
                centerPanel,
                BorderLayout.CENTER
        );





        JButton prevButton =
                new JButton("上一筆");



        JButton nextButton =
                new JButton("下一筆");



        JButton addButton =
                new JButton("新增");




        JPanel bottom =
                new JPanel();



        bottom.add(prevButton);

        bottom.add(nextButton);

        bottom.add(addButton);



        add(
                bottom,
                BorderLayout.SOUTH
        );





        // 上一筆

        prevButton.addActionListener(e -> {


            if(index > 0){

                index--;

                showData();

            }


        });





        // 下一筆

        nextButton.addActionListener(e -> {


            if(index < items.size()-1){

                index++;

                showData();

            }


        });





        // 新增按鈕(目前先測試)

        addButton.addActionListener(e -> {


            MesItem item =
                    items.get(index);



            System.out.println(
                    "準備新增:"
                    + item.getItemName()
            );



            javax.swing.JOptionPane.showMessageDialog(
                    this,
                    "新增成功 OK"
            );


        });




        showData();


    }






    private void showData(){


        MesItem item =
                items.get(index);




        typeLabel.setText(
                item.getItemType()
        );



        nameLabel.setText(
                item.getItemName()
        );



        fullNameLabel.setText(
                item.getFullName()
        );



        specLabel.setText(
                item.getSpecification()
        );



        tempLabel.setText(
                item.getTemperature()
        );



        unitLabel.setText(
                item.getUnit()
        );



        priceLabel.setText(
                String.valueOf(
                        item.getPrice()
                )
        );





        setTitle(
                "MES新增資料 "
                +(index+1)
                +"/"
                +items.size()
        );


    }


}