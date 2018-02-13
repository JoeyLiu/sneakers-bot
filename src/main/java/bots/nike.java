/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

import static bots.Common.waitforms;
import java.util.ArrayList;

import java.util.logging.Level;
import org.openqa.selenium.By;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 *
 * @author damaomao
 */
abstract class nike extends Common{
    static String sku;
    ArrayList<String> enterTexts = new ArrayList<String>();
    String loginText;
    String loginButtonText;
    String okText;
    
    public void setID(String id){
        sku = id;
    }
    abstract void countrySelect();
    abstract void choosePayMethod();
    void enter(){
        while(true){
            for(int i=0;i<enterTexts.size();i++){
                try{               
                    driver.findElement(By.partialLinkText(enterTexts.get(i))).click();
                    LOGGER.log(Level.SEVERE,enterTexts.get(i) + " Clicked.");
                }
                catch(Exception e){
                    LOGGER.log(Level.SEVERE,enterTexts.get(i) + " NOT found.");
                    waitforms(100);
                }
            }
            try{
                driver.findElement(By.partialLinkText("继续购物"));
                break;
            }
            catch(Exception e){
                    waitforms(100);
            }
            try{
                driver.findElement(By.partialLinkText("Continue Shopping"));
                break;
            }
            catch(Exception e){
                    waitforms(100);
            }
        }
    }
    void login(String user){
        /*
        * login
        */
        driver = firefox.launch();
        driver.get(BASEURL + "sb-air-force-2-low-kevin-bradley");
        waitforms(1000);
        
        countrySelect();
        
        String username = user;              
        String password = "Lyly19821225";
        LOGGER.log(Level.SEVERE,"Open login window");
        WebElement login = driver.findElement(By.xpath("//a[@aria-label='" + loginText + "']"));
        login.click();
        waitforms(15000);
        
        LOGGER.log(Level.SEVERE,"Input email and password");
        WebElement userele = driver.findElement(By.name("emailAddress"));
        userele.sendKeys(username);
        WebElement pwd = driver.findElement(By.name("password"));
        pwd.sendKeys(password);
        waitforms(3000);
        LOGGER.log(Level.SEVERE,"Click login button");
        WebElement login_btn = driver.findElement(By.xpath("//input[@value='" + loginButtonText + "']"));
        login_btn.click();
        waitforms(25000);
        boolean login_success = false;
        while(!login_success){
            try{
                WebElement ok = driver.findElement(By.xpath("//input[@value='" + okText + "']"));
                ok.click();
                LOGGER.log(Level.SEVERE,"Login fails, try again");
                waitforms(3000);
                login_btn = driver.findElement(By.xpath("//input[@value='" + loginButtonText + "']"));
                login_btn.click();
                waitforms(3000);
             }
            catch (NoSuchElementException e){
                login_success = true;
                LOGGER.log(Level.SEVERE,"Login succeed");
            }
        }
        choosePayMethod();
        
    }        
    void cop(String user){
        login(user);
        /*
        get back to product
        */
        //LOGGER.log(Level.FINER,"Go to " + getURL());
        driver.get(getURL());
        LOGGER.log(Level.SEVERE,"Reday for " + getURL());
       /*
        ready to start
        */
       redayToStart();
       
       /*
       start
       */
       long begin = System.currentTimeMillis();
       LOGGER.log(Level.FINER,"Go to " + getURL());
       driver.get(getURL());

       enter();
           
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
