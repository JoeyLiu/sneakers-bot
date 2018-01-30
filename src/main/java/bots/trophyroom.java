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
public class trophyroom extends Common{
    private static final String BASEURL = "https://www.trophyroomstore.com/collections/all/products/";
    
    @Override
    public String getURL(){
        return BASEURL + productName;
    }
    @Override
    public void cop(){
        WebDriver driver = firefox.launch();
        driver.get(getURL());
        
        try{
            Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }
        WebElement sizeNum = driver.findElement(By.xpath("//div[@data-value='" + getSize() + "']"));
            sizeNum.click();
                    try{
            Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }
                    
                    WebElement addToCartButton = driver.findElement(By.id(("AddToCartText")));
            addToCartButton.click();
                          try{
            Thread.sleep(1000);
            }
            catch (InterruptedException e){
            }         
        driver.quit();
    }
}
