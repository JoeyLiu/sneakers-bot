/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static bots.Common.LOGGER;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author damaomao
 */
public class footlocker extends Common{
    private static final String BASEURL = "https://www.footlocker.com/product";
    private static String model;
    private static String sku;
    
    @Override
    public String getURL(){
        return BASEURL + "/model:" + model + "/sku:" + sku + "/" + productName;
    }
    public void setModel(String model){
        footlocker.model = model;
    }
    public void setSku(String sku){
        footlocker.sku = sku;
    }

    
    @Override
    public void cop(String size){            
            WebDriver driver2=firefox.launch();
            driver2.get(getURL());
            for (Cookie ck : cks) {
               Cookie newck = new Cookie(ck.getName(),ck.getValue(),ck.getDomain(),ck.getPath(),ck.getExpiry(),ck.isSecure());
               driver2.manage().addCookie(newck);
                
            }
            driver2.get(getURL());
            redayToStart();
            driver2.get(getURL());
            //TryAndClick("//*[@id='pdp_size_select_containe']",driver2);
            WebElement sizeButton = driver2.findElement(By.id(("pdp_size_select_container")));
            sizeButton.click();
            
            waitforms(500);
            
            //TryAndClick("//*[@id='size_selection_list']/a[@value=" + size + "]",driver2);
            LOGGER.log(Level.SEVERE,"Cop size: " + size);
            WebElement sizeNum = driver2.findElement(By.xpath("//*[@id='size_selection_list']/a[@value=" + size + "]"));
            sizeNum.click();
            
            waitforms(500);
            
            WebElement addToCartButton = driver2.findElement(By.id(("pdp_addtocart_button")));
            addToCartButton.click();
            //WebElement checkOutButton = driver2.findElement(By.xpath("//a[@title='Checkout Button']"));
            //checkOutButton.click();
            //Thread.sleep(3000);
            //driver.quit();
    }
    
    @Override
    Set<Cookie> login(){
        driver = firefox.launch();
        driver.get(getURL());
        String username = "juneslayer@gmail.com";              
        String password = "Lyly1225";
        WebElement login = driver.findElement(By.id("header_account_access"));
        login.click();
            try{
            Thread.sleep(4000);
            }
            catch (InterruptedException e){
            }
            driver.switchTo().frame("loginIFrame");
        WebElement user = driver.findElement(By.id("login_email"));
        user.sendKeys(username);
        WebElement pwd = driver.findElement(By.id("login_password"));
        pwd.sendKeys(password);
        WebElement login_btn = driver.findElement(By.xpath("//button[@data-btnname='loginIframe_login']"));
        login_btn.click();
            try{
            Thread.sleep(5000);
            }
            catch (InterruptedException e){
            }
            driver.switchTo().defaultContent();
            cks = driver.manage().getCookies();
            WebElement cart = driver.findElement(By.id("header_cart_button"));
            cart.click();
            waitforms(5000);
            return cks;
    }
}
