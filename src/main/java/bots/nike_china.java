/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static bots.Common.cks;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yueliliu
 */
public class nike_china extends Common{
    private static final String BASEURL = "https://www.nike.com/cn/launch/t/";
    private static final String[] USERS = {"juneslayer@gmail.com", "121225135@qq.com","lyly19821225@sina.com","juneslayer_0@gmail.com"};
    @Override
    public String getURL(){
        return BASEURL + productName;
    }
    
    @Override
    Set<Cookie> login(){
        
        
        return cks;
    }
    WebDriver login(String user){
        /*
        * login
        */
        WebDriver driver = firefox.launch();
        driver.get("https://www.nike.com/cn/launch/t/kyrie-4-parquet-legends");
            try{
                Thread.currentThread().sleep(1000);
            }
                catch (InterruptedException e){
            }
        
        String username = user;              
        String password = "Lyly19821225";
        WebElement login = driver.findElement(By.xpath("//a[@aria-label='加入或登录']"));
        login.click();
            try{
            Thread.currentThread().sleep(5000);
            }
            catch (InterruptedException e){
            }
           
        WebElement userele = driver.findElement(By.name("emailAddress"));
        userele.sendKeys(username);
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
         try{
            Thread.currentThread().sleep(3000);
            }
            catch (InterruptedException e){
            }
        WebElement login_btn = driver.findElement(By.xpath("//input[@value='登录']"));
        login_btn.click();
            try{
            Thread.currentThread().sleep(1000);
            }
            catch (InterruptedException e){
            }
        boolean login_success = false;
        while(!login_success){
            try{
                WebElement ok = driver.findElement(By.xpath("//input[@value='确定']"));
                ok.click();
                try{
                Thread.currentThread().sleep(3000);
                }
                catch (InterruptedException e){
                }
                login_btn = driver.findElement(By.xpath("//input[@value='登录']"));
                login_btn.click();
                try{
                Thread.currentThread().sleep(3000);
                }
                catch (InterruptedException e){
                }
                try{
                    ok = driver.findElement(By.xpath("//input[@value='确定']"));
                }    
                catch (NoSuchElementException e){
                   login_success = true;
                }
             }
            catch (NoSuchElementException e){
            
            }
        }
        
        
            try{
            Thread.currentThread().sleep(10000);
            }
            catch (InterruptedException e){
            }
           //driver.get(getURL());
          
        /*
           choose AliPay
           */
        driver.get("https://www.nike.com/cn/launch/t/kyrie-4-parquet-legends?action=buy&id=AJ1691-001&size=42");
            
        TryAndClick("//a[@data-provide='aliPayId']", driver);

            try{
                Thread.currentThread().sleep(5500);
            }
                catch (InterruptedException e){
            }

        WebElement save = driver.findElements(By.partialLinkText("保存并继续")).get(2);
        save.click();
            try{
                Thread.currentThread().sleep(1500);
            }
                catch (InterruptedException e){
            }
            return driver;
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
       System.out.println("Start!");
       long begin = System.currentTimeMillis();
       TryAndClick("//div[@data-juno-name='sizeSelector']", driver);         

        TryAndClick("//ul[@data-juno-name='sizeGrid']/li[@data-size='" + getSize() + "']", driver);   

        WebElement buy = driver.findElement(By.partialLinkText("购买"));
        buy.click();
                    
        //TryAndClick("//a[text()='提交订单']", driver);
        long end = System.currentTimeMillis();
        System.out.println(end-begin);
        
        boolean retry = false;
        WebElement retryele;
        //p 请重试
        int i=0;
        while(i<200){
            try{
                retryele = driver.findElement(By.partialLinkText("请重试"));               
                TryAndClick("//a[text()='提交订单']", driver);
                i++;
            }
            catch(NoSuchElementException e){
                waitforms(100);
            }
        }
       // System.out.println("try " + i + " times done");

        //driver.quit();
    }        
    
}
