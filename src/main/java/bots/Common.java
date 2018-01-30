/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bots;

/**
 *
 * @author damaomao
 */
public abstract class Common {
    static String productName;
    static String size;
    void setProductName(String productName){
        Common.productName = productName;
    }
    void setSize(String size){
        Common.size = size;
    }
    public String getSize(){
        return size;
    }
    abstract String getURL();
    abstract void cop();

}
