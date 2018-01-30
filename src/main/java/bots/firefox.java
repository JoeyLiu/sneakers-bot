/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;





import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author damaomao
 */
public class firefox {

    /**
     *
     * 
     * @return 
     */
    public static WebDriver launch() {
        
        
            System.setProperty("webdriver.gecko.driver","D:/bots/geckodriver.exe");
            return new FirefoxDriver();
           
    }
   
}
