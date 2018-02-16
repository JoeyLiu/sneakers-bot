/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static bots.Common.target;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author damaomao
 * next:
 * bots can use different account
 * bots can pick up different sizes
 * bots can pick up different products at the same time
 * set policy: 1. account 2.size 3. quantity 4. product
 * add nike china: 2390ms placing an order
 *  - repeat if fail. done. try 200 times.
 * add nike us
 * 
 * 2/8 4:00pm, test adi us
 * 2/18 10:00pm, adi us, bape dame 4, dame-4--bape-shoes/AP9975, dame-4--bape-shoes/AP9974
 * 2/10 9:00am, nike china, jordan 1 gold toe
 * 2/16 footlocker/finish line, gold toe
 * 2/24 footlocker, bredtoe
 * 
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
          
//            adidas_us adi = new adidas_us();
//            adi.setProductName("dame-4-shoes");
//            adi.setSKU("AC8646");
//            adi.setSize("8.5");
//            adi.setClock(0, 10);
//            adi.cops();
        
//            nike_china nike = new nike_china();
//            nike.setProductName(args[0]);
//            nike.setSize(args[1]);
//            //nike.setID(args[5]);
//            nike.setClock(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
//            //System.out.println(nike.getURL());
//            //https://www.nike.com/cn/launch/t/sb-air-force-2-low-kevin-bradley?id=AO0298-114&size=42
//            nike.cop(args[4]);
            //nike_us(args);
            
            //test.test_nike_china();
            
            //test.test_nike_us();
            
            //nike_china(args);
            nike_us(args);
            

    }
    public static void nike_us(String[] args){
            nike_us nike = new nike_us();
            nike.setProductName(args[0]);
            nike.setSize(args[1]);
            nike.setID(args[5]);
            nike.setClock(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            //System.out.println(nike.getURL());AT7815-002
            //https://www.nike.com/cn/launch/t/sb-air-force-2-low-kevin-bradley?id=AO0298-114&size=42
            nike.cop(args[4]);
    }
        public static void nike_china(String[] args){
            nike_china nike = new nike_china();
            nike.setProductName(args[0]);
            nike.setSize(args[1]);
            nike.setID(args[5]);
            nike.setClock(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            //System.out.println(nike.getURL());AT7815-002
            //https://www.nike.com/cn/launch/t/air-jordan-3-free-throw-line?id=923096-101&size=9
            nike.cop(args[4]);
    }

}
