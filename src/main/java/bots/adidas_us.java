/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;


import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.InvalidCookieDomainException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author damaomao
 */
public class adidas_us extends Common{
     private static final String BASEURL = "https://www.adidas.com/us/";
     private static String productName;
     private static String sku;
     
    @Override
    public String getURL(){
        return BASEURL + productName + "/" + sku + ".html";
    }
    
     @Override
    public void setProductName(String product){
        productName = product;
    }
    
    public void setSKU(String Sku){
        sku = Sku;
    }
    
    @Override
    void cop(){
        
        WebDriver driver=firefox.launch();
        driver.get(getURL());
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
            }
         for (Cookie ck : cks) {
             try{
             Cookie newck = new Cookie(ck.getName(),ck.getValue(),ck.getDomain(),ck.getPath(),ck.getExpiry(),ck.isSecure());
             driver.manage().addCookie(newck);
             }
             catch (InvalidCookieDomainException e){
             Cookie newck = new Cookie(ck.getName(),ck.getValue(),"www.adidas.com",ck.getPath(),ck.getExpiry(),ck.isSecure());
             driver.manage().addCookie(newck);
             }
         }
        driver.get(getURL());
            try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
            }
            
        redayToStart();
        System.out.println(">>>>>>>>>>>>>>>Start!");
        WebElement sizelist = driver.findElement(By.xpath("//div[@data-auto-id='size-selector']"));
        sizelist.click();
        
            try{
                Thread.sleep(1000);
            }
                catch (InterruptedException e){
            }
        WebElement size = driver.findElement(By.xpath("//div[@data-auto-id='item-wrapper']//li[@title='" + getSize() + "']"));
        size.click();
        
            try{
                Thread.sleep(2000);
            }
                catch (InterruptedException e){
            }
        WebElement add_to_bag = driver.findElement(By.xpath("//button[@data-auto-id='add-to-bag']"));
        add_to_bag.click();
        
            try{
                Thread.sleep(10000);
            }
                catch (InterruptedException e){
            }
            
        // WebElement continue_shop = driver.findElement(By.className("icon icon-close"));
        // continue_shop.click();
        driver.quit();
        
    }
    
    
     @Override
    Set<Cookie> login(){
        WebDriver driver = firefox.launch();
        driver.get(getURL());
                    try{
                Thread.sleep(1000);
            }
                catch (InterruptedException e){
            }
        
        
        String username = "juneslayer@gmail.com";              
        String password = "Lyly1225";
        WebElement login = driver.findElement(By.xpath("//a[@manual_cm_sp='customer_info-_-Sign in']"));
        login.click();
            try{
            Thread.sleep(5000);
            }
            catch (InterruptedException e){
            }
        driver.switchTo().frame("loginaccountframe");    
        WebElement user = driver.findElement(By.id("username"));
        user.sendKeys(username);
        WebElement pwd = driver.findElement(By.id("password"));
        pwd.sendKeys(password);
        WebElement login_btn = driver.findElement(By.id("signinSubmit"));
        login_btn.click();
            try{
            Thread.sleep(10000);
            }
            catch (InterruptedException e){
            }
            driver.switchTo().defaultContent();
            cks = driver.manage().getCookies();
            driver.quit();
            return cks;
    }
}
