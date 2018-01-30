/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm;

/**
 *
 * @author damaomao
 */
public class randomInt {
    public static int[] get(){
        int count = (int) (Math.random() * 100);
        int[] random = new int[count];
        for(int i=0;i<random.length;i++){
            int num = (int) (Math.random() * 100);
        
            //System.out.println(num);
            random[i] = num;
        }
        for(int b: random){
            System.out.print(b + ",");
        }
        System.out.println("");
        return random;
    }
}
