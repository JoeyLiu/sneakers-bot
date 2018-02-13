/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    static final Logger LOGGER = Logger.getLogger("myLogger");
    
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
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(target);
        calendar.set(Calendar.MILLISECOND, 0);
        target = calendar.getTime();
        //System.out.println(df.format(target));
        
    }
    public void redayToStart(){
        
        current = new Date();       
        while(target.compareTo(current) > 0){
            waitforms(100);
            current = new Date();
            LOGGER.log(Level.FINER,"Target: " + df.format(target) + " Current: " + df.format(current));
        }
        LOGGER.log(Level.SEVERE,df.format(current));
    }
    void cops(){
        int threads = 4;
        cks = login();
        ExecutorService executor = Executors.newFixedThreadPool(threads);
//        Runnable copone = () -> {
//            cop();
//        };
        for(int i=0;i<threads;i++){
            copones copone = new copones();
//            copone.setUserID(i);
            executor.execute(copone);           
        }
        
        //executor.execute(copone);
        //executor.execute(copone);
        
        executor.shutdown();
    }
    class copones implements Runnable{
        private String userID;
        public void run(){
            cop(userID);
        }
        void setUserID(String user){
            this.userID = user;
        }
    }
    static void waitforms(int ms){
        LOGGER.log(Level.FINER,"Wait for " + ms + " ms");
            try{
                Thread.currentThread().sleep(ms);
            }
                catch (InterruptedException e){
            }
    }
    void TryAndClick(String xpath, WebDriver driver){
        LOGGER.log(Level.FINER,"Try..." + xpath);
        try{
        WebElement ele = driver.findElement(By.xpath(xpath));
        LOGGER.log(Level.FINER,"Element: " + xpath + " found");

        ele.click();
        LOGGER.log(Level.FINER,"Element: " + xpath + " clicked");
        }
        catch (NoSuchElementException|ElementNotInteractableException e){
            //e.printStackTrace();
            LOGGER.log(Level.FINER,e.getMessage());
            waitforms(100);
            
            TryAndClick(xpath, driver);
        }
        
        
    }
    abstract String getURL();   
    abstract Set<Cookie> login();
    abstract void cop(String user);
    

}
