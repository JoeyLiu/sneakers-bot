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
public class swap {
    public static void QuickSort(int[] a){
        quick(0,(a.length-1), a);
        for(int b: a){
            System.out.print(b + ",");
        }
        System.out.println("");
    }
    private static void quick(int left, int right, int[] array){
             if(left >= right) {              
                 return;
             }
             
             int key = array[left];
             int low = left;
             int high = right;
             
             
             while(low < high){
             while(low < high && array[high] >= key) high--;
            
             int temp = array[low];
             array[low] = array[high];
             array[high] = temp;
            
                           
             while(low < high && array[low] <= key) low++;
              
             temp = array[high];
             array[high] = array[low];
             array[low] = temp;
             
             }
             
             
             quick(left, low-1, array);
             quick(low+1, right, array);
         }
        public static void BubbleSort(int[] a){
        int length = a.length;
       
        for(int i=length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        for(int b: a){
            System.out.print(b + ",");
        }
        System.out.println("");
    }
}
