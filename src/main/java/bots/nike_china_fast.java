/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static bots.Common.cks;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.InvalidCookieDomainException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yueliliu
 */
public class nike_china_fast extends nike_china{
    private static final String BASEURL = "https://www.nike.com/cn/launch/t/";
    private static String sku;
    
    @Override
    public String getURL(){
        return BASEURL + productName + "?action=buy&id=" + sku + "&size=" + getSize();
        //https://www.nike.com/cn/launch/t/air-jordan-3-retro-og-cement-2018?id=854262-001&size=42
    }
    public void setID(String id){
        sku = id;
    }
    
    void cop(String user){
       
        WebDriver driver = login(user);
        /*
        get back to product
        */
        driver.get(getURL());
        
       /*
        ready to start
        */
       redayToStart();
       
       /*
       start
       */
       long begin = System.currentTimeMillis();
       driver.get(getURL());

        while(true){
           try{     
            WebElement submit = driver.findElement(By.partialLinkText("提交订单"));
            submit.click();
            break;
            }
           catch(Exception e){
               //e.printStackTrace();
           }
           try{
               driver.findElement(By.partialLinkText("确定")).click();
               driver.get(getURL());
            }
            catch(Exception e2){
            }  
        }
           
        //TryAndClick("//a[text()='提交订单']", driver);
        
        long end = System.currentTimeMillis();
        
        
       int i=0;
       int j=0;
       while(i<200 && j<3000){
            try{
                WebElement retryele = driver.findElement(By.partialLinkText("请重试"));               
                TryAndClick("//a[text()='提交订单']", driver);
                i++;
            }
            catch(NoSuchElementException e){
                System.out.println("retry");
                waitforms(100);
                j++;
            }
       }
       System.out.println("try " + i + " times done");

       System.out.println(end-begin);
        //driver.quit();
    
    }
            
}
