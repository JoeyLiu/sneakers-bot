/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author damaomao
 * next:
 * bots can use different account
 * bots can pick up different sizes
 * bots can pick up different products at the same time
 * set policy: 1. account 2.size 3. quantity 4. product
 * add nike china
 * add nike us
 * 
 * 
 */
public class bots {
    public static void main(String[] args) throws InterruptedException{       
       
//        footlocker footlocker = new footlocker();
//        footlocker.setModel("288527");
//        footlocker.setSku("24453006");
//        footlocker.setSize("08.0");
//        footlocker.setProductName("nike-air-vapormax-plus-mens");
//        footlocker.cop();
          
//        trophyroom tr = new trophyroom();
//        tr.setProductName("air-jordan-1-retro-soh-barely-grape-1");
//        tr.setSize("8");
//        tr.cop();
          
            adidas_us adi = new adidas_us();
            adi.setProductName("dame-4-shoes");
            adi.setSKU("AC8646");
            adi.setSize("8.5");
            adi.setClock(0, 10);
            adi.cops();
        

    }
}
