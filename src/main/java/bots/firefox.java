/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//        firefoxBinary.addCommandLineOptions("--headless");
         System.setProperty("webdriver.gecko.driver","./drivers/geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
       firefoxOptions.setBinary(firefoxBinary);
            return new FirefoxDriver(firefoxOptions);
//        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver2.35.exe");
//        ChromeOptions chromeOptions = new ChromeOptions();
////      设置为 headless 模式 （必须）
//        chromeOptions.addArguments("--headless");
//        return new ChromeDriver(chromeOptions);

//       WebDriver driver = null;
//        try {
//            DesiredCapabilities capability = DesiredCapabilities.firefox();
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
//            
//        } catch (MalformedURLException ex) {
//            Logger.getLogger(firefox.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return driver;
    }
   
}
