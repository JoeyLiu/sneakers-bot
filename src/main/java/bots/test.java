package bots;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author damaomao
 */


//import org.testng.annotations.Test;


public class test {
    
    public static void test_nike_china(){
        String[] args={"air-jordan-3-retro-og-cement-2018","42","23","40","juneslayer@gmail.com","AO0298-114"};
            nike_china nike = new nike_china();
            
            nike.setProductName(args[0]);
            nike.setSize(args[1]);
            nike.setID(args[5]);
            nike.setClock(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            //System.out.println(nike.getURL());AT7815-002
            //https://www.nike.com/cn/launch/t/sb-air-force-2-low-kevin-bradley?id=AO0298-114&size=42
            nike.cop(args[4]);
    }
        public static void test_nike_us(){
        String[] args={"air-jordan-3-retro-og-cement-2018","8","21","57","juneslayer@gmail.com","854262-001"};
            nike_us nike = new nike_us();
            
            nike.setProductName(args[0]);
            nike.setSize(args[1]);
            nike.setID(args[5]);
            nike.setClock(Integer.valueOf(args[2]), Integer.valueOf(args[3]));
            //System.out.println(nike.getURL());AT7815-002
            //https://www.nike.com/cn/launch/t/sb-air-force-2-low-kevin-bradley?id=AO0298-114&size=42
            nike.cop(args[4]);
    }
    
}
