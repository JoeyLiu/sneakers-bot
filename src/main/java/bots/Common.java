/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author damaomao
 */
public abstract class Common {
    static String productName;
    static String size;
    static Date date;
    static Set<Cookie> cks;
    static Date target = new Date();
    static Date current;
    
    
    void setProductName(String productName){
        Common.productName = productName;
    }
    void setSize(String size){
        Common.size = size;
    }
    public String getSize(){
        return size;
    }
    public void setClock(int hour, int minute){
       
        target.setHours(hour);
        target.setMinutes(minute);
        target.setSeconds(0);
    }
    public void redayToStart(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        current = new Date();       
        while(target.compareTo(current) > 0){
            try{
                Thread.sleep(50);
            }
                catch (InterruptedException e){
            }
            current = new Date();
            //System.out.println("Target: " + df.format(target) + "Current: " + df.format(current));
        }
        System.out.println(df.format(current));
    }
    void cops(){
        int threads = 2;
        cks = login();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
//        Runnable copone = () -> {
//            cop();
//        };
        for(int i=0;i<threads;i++){
            copones copone = new copones();
            copone.setUserID(i);
            executor.execute(copone);           
        }
        
        //executor.execute(copone);
        //executor.execute(copone);
        
        executor.shutdown();
    }
    class copones implements Runnable{
        private int userID;
        public void run(){
            cop(userID);
        }
        void setUserID(int id){
            this.userID = id;
        }
    }
    void TryAndClick(String xpath, WebDriver driver){
        System.out.println("Try..." + xpath);
        try{
        WebElement ele = driver.findElement(By.xpath(xpath));
        System.out.println("Found");
        ele.click();
        System.out.println("Clicked");
        }
        catch (NoSuchElementException|ElementNotInteractableException e){
            //e.printStackTrace();
            try{
            Thread.currentThread().sleep(100);
            }
            catch(InterruptedException e2){
                
            }
            
            TryAndClick(xpath, driver);
        }
        
        
    }
    abstract String getURL();   
    abstract Set<Cookie> login();
    abstract void cop(int userID);
    

}
