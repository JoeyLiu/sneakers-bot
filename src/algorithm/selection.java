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
public class selection {
    public static void simpleSelectionSort(int[] a){
        int length = a.length;
        int min_index = 0;
        for(int i=0;i<length;i++){
           // minimum = a[i];
            min_index = i;
            for(int j=i+1;j<length;j++){           
            if(a[j]<a[min_index]) {
                //minimum =a[j];
                min_index=j;
            }
            }
            int temp = a[i];
            a[i] = a[min_index];
            a[min_index] = temp;
        }
        for(int b: a){
            System.out.print(b + ",");
        }
        System.out.println("");
    }
    public static void HeapSort(int[] a){
        
    }
}
