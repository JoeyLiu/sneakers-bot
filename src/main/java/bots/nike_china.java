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
        WebDriver driver = firefox.launch();
        driver.get(getURL());
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
            
            cks = driver.manage().getCookies();    
            
        driver.quit();
        return cks;
    }
            
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
             //Cookie newck = new Cookie(ck.getName(),ck.getValue(),"www.nike.com",ck.getPath(),ck.getExpiry(),ck.isSecure());
             //driver.manage().addCookie(newck);
                //e.printStackTrace();
                Set<Cookie> temp = driver.manage().getCookies(); 
                for(Cookie tem:temp){
                    System.out.println(ck.getDomain() + " - " + tem.getDomain());

                }
             }
         }
        driver.get(getURL());
                    try{
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
            }
                    
                    
        driver.quit();
    }        
    
}
