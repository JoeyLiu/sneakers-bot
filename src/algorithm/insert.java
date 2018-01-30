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
public class insert {
    public static void StraightInsertSort(int[] a){
        int len = a.length;
        for(int i=1;i<len;i++){
            int ins = a[i];
            int j=i-1;
            while(j>=0 && a[j] > ins){
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = ins;
        }
        for(int b: a){
            System.out.print(b + ",");
        }
        System.out.println("");
    }
    public static void Shell(int[] a){
        
    }
}
