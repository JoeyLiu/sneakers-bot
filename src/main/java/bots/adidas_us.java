/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import org.openqa.selenium.By;
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
        WebElement sizelist = driver.findElement(By.xpath("//div[@data-auto-id='size-selector']"));
        
        sizelist.click();
                    try{
            Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }
                    WebElement size = driver.findElement(By.xpath("//div[@data-auto-id='item-wrapper']//li[@title='7']"));
                    size.click();
                    
    }
}
