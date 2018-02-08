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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yueliliu
 */
public class nike_china extends Common{
    private static final String BASEURL = "https://www.nike.com/cn/launch/t/";
    
    @Override
    public String getURL(){
        return BASEURL + productName;
    }
    
    @Override
    Set<Cookie> login(){
        
        
        return cks;
    }
            
    void cop(){
        /*
        * login
        */
        WebDriver driver = firefox.launch();
        driver.get("https://www.nike.com/cn/launch/t/kyrie-4-parquet-legends");
            try{
                Thread.sleep(1000);
            }
                catch (InterruptedException e){
            }
        
        String username = "juneslayer@gmail.com";              
        String password = "Lyly19821225";
        WebElement login = driver.findElement(By.xpath("//a[@aria-label='加入或登录']"));
        login.click();
            try{
            Thread.sleep(5000);
            }
            catch (InterruptedException e){
            }
           
        WebElement user = driver.findElement(By.name("emailAddress"));
        user.sendKeys(username);
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
        WebElement login_btn = driver.findElement(By.xpath("//input[@value='登录']"));
        login_btn.click();
            try{
            Thread.sleep(10000);
            }
            catch (InterruptedException e){
            }
           //driver.get(getURL());
          
        /*
           choose AliPay
           */
        
        
        TryAndClick("//div[@data-juno-name='sizeSelector']", driver);         
       
//                    try{
//            Thread.sleep(500);
//            }
//            catch (InterruptedException e){
//            }
        TryAndClick("//ul[@data-juno-name='sizeGrid']/li[@data-size='" + getSize() + "']", driver);   
//        WebElement size = driver.findElement(By.xpath("//ul[@data-juno-name='sizeGrid']/li[@data-size='" + getSize() + "']"));
//        size.click();
        
        WebElement buy = driver.findElement(By.partialLinkText("购买"));
        buy.click();
            try{
                Thread.sleep(6500);
            }
                catch (InterruptedException e){
            }
            
        TryAndClick("//a[@data-provide='aliPayId']", driver);
//        WebElement aliPay = driver.findElement(By.xpath("//a[@data-provide='aliPayId']"));
//        aliPay.click();
        //WaitAndClick("//a[@data-provide='aliPayId']", driver);
                   try{
                Thread.sleep(5500);
            }
                catch (InterruptedException e){
            }
        //WaitAndClick("//div[@data-juno-name='saveButton']", driver);
        
        //TryAndClick("//a[text()='保存并继续']", driver);
        WebElement save = driver.findElements(By.partialLinkText("保存并继续")).get(2);
        save.click();
            try{
                Thread.sleep(1500);
            }
                catch (InterruptedException e){
            }
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
       TryAndClick("//div[@data-juno-name='sizeSelector']", driver);         
       
//                    try{
//            Thread.sleep(500);
//            }
//            catch (InterruptedException e){
//            }
        TryAndClick("//ul[@data-juno-name='sizeGrid']/li[@data-size='" + getSize() + "']", driver);   

        buy = driver.findElement(By.partialLinkText("购买"));
        buy.click();
                    
        TryAndClick("//a[text()='提交订单']", driver);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        
        int i=0;
        while(i<200){
            
        TryAndClick("//a[text()='提交订单']", driver);
        i++;
        }
        System.out.println("try " + i + " times done");
        //WebElement order = driver.findElement(By.partialLinkText("提交订单"));
        //order.click();
        //driver.quit();
    }        
    
}
