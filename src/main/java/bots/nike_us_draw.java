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
public class nike_us_draw extends nike_us{
    private static final String BASEURL = "https://www.nike.com/launch/t/";
    private static String sku;
    
    @Override
    public String getURL(){
        return BASEURL + productName + "?action=buy&id=" + sku + "&size=" + getSize();
        //https://www.nike.com/cn/launch/t/air-jordan-3-retro-og-cement-2018?id=854262-001&size=42
    }
    public void setID(String id){
        sku = id;
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
        driver.get(BASEURL + "sb-air-force-2-low-kevin-bradley");
        waitforms(1000);
        WebElement countryele = driver.findElement(By.xpath("//a[@class='js-lang-tunnel']/img"));
        countryele.click();
        waitforms(2000);
        TryAndClick("//span[text()='中国']", driver);
        waitforms(3000);
        countryele = driver.findElement(By.xpath("//a[@class='js-lang-tunnel']/img"));
        countryele.click();
        waitforms(2000);
        TryAndClick("//span[text()='United States']", driver);
        waitforms(10000);
        
        String username = user;              
        String password = "Lyly19821225";
        WebElement login = driver.findElement(By.xpath("//a[@aria-label='Join or Log In']"));
        login.click();
        waitforms(15000);
           
        WebElement userele = driver.findElement(By.name("emailAddress"));
        userele.sendKeys(username);
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
        waitforms(3000);
        WebElement login_btn = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        login_btn.click();
        waitforms(25000);
        boolean login_success = false;
        while(!login_success){
            try{
                WebElement ok = driver.findElement(By.xpath("//input[@value='OK']"));
                ok.click();
                waitforms(3000);
                login_btn = driver.findElement(By.xpath("//input[@value='LOG IN']"));
                login_btn.click();
                waitforms(3000);
             }
            catch (NoSuchElementException e){
                login_success = true;
            }
        }
        //waitforms(10000);
           //driver.get(getURL());
          
        /*
           choose AliPay
           */
        //driver.get("https://www.nike.com/cn/launch/t/kyrie-4-parquet-legends?action=buy&id=AJ1691-001&size=42");            
        //TryAndClick("//a[@data-provide='aliPayId']", driver);
        //waitforms(5500);
        //WebElement save = driver.findElements(By.partialLinkText("保存并继续")).get(2);
        //save.click();
        //waitforms(1500);
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
       long begin = System.currentTimeMillis();
       driver.get(getURL());

        while(true){
           try{    
               /*
            click OK and click Confirm and click Submit order
            */
            WebElement submit = driver.findElement(By.partialLinkText("Submit Order"));
            submit.click();
            
            break;
            }
           catch(Exception e){
               //e.printStackTrace();
           }
           try{
               driver.findElement(By.partialLinkText("OK")).click();
               driver.get(getURL());
            }
            catch(Exception e2){
            }  
        }
           
        //TryAndClick("//a[text()='提交订单']", driver);
        
        long end = System.currentTimeMillis();
        
        
//       int i=0;
//       int j=0;
//       while(i<200 && j<3000){
//            try{
//                WebElement retryele = driver.findElement(By.partialLinkText("Please try again"));               
//                TryAndClick("//a[text()='Submit Order']", driver);
//                i++;
//            }
//            catch(NoSuchElementException e){
//                System.out.println("retry");
//                waitforms(100);
//                j++;
//            }
//       }
//       System.out.println("try " + i + " times done");

       System.out.println(end-begin);
        //driver.quit();
    }        
    
}
