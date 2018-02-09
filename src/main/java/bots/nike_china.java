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
        waitforms(1000);
        
        String username = user;              
        String password = "Lyly19821225";
        WebElement login = driver.findElement(By.xpath("//a[@aria-label='加入或登录']"));
        login.click();
        waitforms(30000);
           
        WebElement userele = driver.findElement(By.name("emailAddress"));
        userele.sendKeys(username);
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
        waitforms(3000);
        WebElement login_btn = driver.findElement(By.xpath("//input[@value='登录']"));
        login_btn.click();
        waitforms(5000);
        boolean login_success = false;
        while(!login_success){
            try{
                WebElement ok = driver.findElement(By.xpath("//input[@value='确定']"));
                ok.click();
                waitforms(3000);
                login_btn = driver.findElement(By.xpath("//input[@value='登录']"));
                login_btn.click();
                waitforms(3000);
             }
            catch (NoSuchElementException e){
                login_success = true;
            }
        }
        waitforms(10000);
           //driver.get(getURL());
          
        /*
           choose AliPay
           */
        driver.get("https://www.nike.com/cn/launch/t/kyrie-4-parquet-legends?action=buy&id=AJ1691-001&size=42");            
        TryAndClick("//a[@data-provide='aliPayId']", driver);
        waitforms(5500);
        WebElement save = driver.findElements(By.partialLinkText("保存并继续")).get(2);
        save.click();
        waitforms(1500);
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
       /*
       add driver.get(getURL) to force refresh the page
       */
       driver.get(getURL());
       
       TryAndClick("//div[@data-juno-name='sizeSelector']", driver);         

       TryAndClick("//ul[@data-juno-name='sizeGrid']/li[@data-size='" + getSize() + "']", driver);   

       WebElement buy = driver.findElement(By.partialLinkText("购买"));
       buy.click();
                    
       TryAndClick("//a[text()='提交订单']", driver);
       long end = System.currentTimeMillis();
       
        
       boolean retry = false;
       
       
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
