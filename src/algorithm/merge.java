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
public class merge {
    public static void sort(int[] a){
        int[] temp = new int[a.length];
        MergeSort(a, 0, a.length-1);
        for(int b: a){
            System.out.print(b + ",");
        }
        System.out.println("");
    }
    private static void MergeSort(int[] a, int first, int last){
        if(first < last){
            int mid = (first + last)/2;
            MergeSort(a, first, mid);
            MergeSort(a, mid+1, last);
            Merge(a, first, last);
        }       
    }
    private static void Merge(int[] a,int first, int last){
        int[] temp = new int[last-first+1];
        int mid = (first + last)/2+1;
        final int MIDDLE = mid-1;
        final int FIRST = first;
        int i=0;
        while(first <= MIDDLE && mid <= last){
            if(a[first] <= a[mid]) {
                temp[i++] = a[first++];
                
            }
            else{
                temp[i++] = a[mid++];
               
               
            }
        }
        while(first <= MIDDLE){
            temp[i++] = a[first++];
               
        }
        while(mid <= last){
            temp[i++] = a[mid++];
            
          
        }
        for(int j=0;j<i;j++){
            a[FIRST + j] = temp[j];
        }
        
    }
}
