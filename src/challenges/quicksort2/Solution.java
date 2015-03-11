package challenges.quicksort2;

/**
 * Created by Eric on 15-3-10.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        quicksort(a, 0, N-1);
    }
    public static void quicksort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition(a, left, right);
        quicksort(a, left, pivot-1);

        quicksort(a, pivot+1, right);
        printArray(a, left, right);
    }
    public static void printArray(int[] a, int left, int right){
        for(int i = left; i <= right; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static int partition(int[] a, int left, int right){
        int pivot = a[left];
        ArrayList<Integer> listS = new ArrayList<Integer>();
        ArrayList<Integer> listL = new ArrayList<Integer>();
        for(int i = left; i<= right; i++){
            if(a[i] < pivot){
                listS.add(a[i]);
            }else{
                listL.add(a[i]);
            }
        }
        for(int i = 0; i < listS.size(); i++){
            a[i+left] = listS.get(i);
        }
        for(int i = 0; i < listL.size(); i++){
            a[i+left+listS.size()] = listL.get(i);
        }
        return left+ listS.size();
    }
}