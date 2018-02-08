/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;





import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        // firefoxBinary.addCommandLineOptions("--headless");
         System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
       firefoxOptions.setBinary(firefoxBinary);
            
            return new FirefoxDriver(firefoxOptions);
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver2.35.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
////        设置为 headless 模式 （必须）
//        chromeOptions.addArguments("--headless");
//        return new ChromeDriver(chromeOptions);
           
    }
   
}
