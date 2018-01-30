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
public class algorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            for(int i=0;i<100;i++){
                int[] a = randomInt.get();
                merge.sort(a);
                 //swap.QuickSort(a);
                 // simpleSelection.sort(a);
                //bubblesort.sort(a);
                //insertSort.sort(a);
                if(!check_sort(a)){
                    throw new Exception("a false occurs");
                }
            }
        }
        catch (Exception e){
           e.printStackTrace();
       }        
        
    }
    private static boolean check_sort(int[] a){
        
        for(int i=0;i<a.length-1;i++){
            if(a[i] > a[i+1]) {
                return false;              
            }
        }
        return true;
    }
    
}
