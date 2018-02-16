/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 *
 * @author yueliliu
 */
public class nike_us extends nike{
    
    

    public nike_us() {
        BASEURL = "https://www.nike.com/launch/t/";
        loginText = "Join or Log In";
        loginButtonText = "LOG IN";
        okText = "OK";
       
        enterTexts.add("Submit Order");
        enterTexts.add("SUBMIT ORDER");
        enterTexts.add("Ok");
        enterTexts.add("OK");
        enterTexts.add("Confirm");
        enterTexts.add("CONFIRM");
   
    
        LOGGER.setLevel(Level.SEVERE); 
 
    }
    
    @Override
    public String getURL(){
        return BASEURL + productName + "?action=buy&id=" + sku + "&size=" + getSize();
        //https://www.nike.com/cn/launch/t/air-jordan-3-retro-og-cement-2018?id=854262-001&size=42
    }
            
    void countrySelect(){
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
    }
    
    void choosePayMethod(){
        LOGGER.log(Level.SEVERE,"Skipping choose pay method in US");
    }
    
    
    
    
}
