package challenges.warmup_sorting.almost_sorted;

/**
 * Created by Zhenyi Luo on 15-3-14.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        if(isSorted(a)){
            System.out.println("yes");
        }else if(canSwap(a)){
            // Do nothing
        }else if(canReverse(a)){
            // Do nothing
        }else{
            System.out.println("no");
        }
    }
    public static boolean isSorted(int[] a){
        int len = a.length;
        boolean flag = true;
        for(int i = 1; i < len && flag; i++){
            if(a[i] < a[i-1]){
                flag = false;
            }
        }
        return flag;
    }

    public static boolean canSwap(int[] a){
        int len = a.length;
        int index1 = -1;
        int index2 = -1;
        int index3 = -1;
        boolean flag = true;
        for(int i = 1; i < len && flag; i++){
            if(a[i] < a[i-1]){
                if(index1 == -1){
                    index1 = i;
                    index2 = i+1;
                }else if(index3 == -1){
                    index3 = i+1;
                }else{
                    flag = false;
                }
            }
        }
        if(!flag){
            return flag;
        }else{

            if(index3 == -1){
                swap(a, index1-1, index2-1);
                if(isSorted(a)){
                    System.out.println("yes");
                    System.out.println("swap " + index1 + " " + index2);
                }else{
                    System.out.println("no");
                }

            }else{
                swap(a, index1-1, index3-1);
                if(isSorted(a)){
                    System.out.println("yes");
                    System.out.println("swap " + index1 + " " + index3);
                }else{
                    System.out.println("no");
                }
            }
            return flag;
        }
    }

    public static boolean canReverse(int[] a){
        int len = a.length;
        boolean flag = true;
        int index1 = -1;
        int index2 = -1;
        int index = 1;
        // acending part
        for(; index < len; index++){
            if(a[index] < a[index-1]){
                break;
            }
        }
        index1 = index ;
        // descending part
        for(; index < len; index++){
            if(a[index] > a[index-1]){
                break;
            }
        }
        index2 = index ;
        // continue check, the rest should be all ascending
        for(; index < len && flag; index++){
            if(a[index] < a[index-1]){
                flag = false;
            }
        }
        if(!flag){
            return flag;
        }else{
            System.out.println("yes");
            System.out.println("reverse " + index1 + " " + index2);
            return flag;
        }
    }
    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}