package challenges.warmup_sorting.find_median;

/**
 * Created by Zhenyi Luo on 15-3-12.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        int[] tmp = ar.clone();
        System.out.println(quickSortForMedian(ar, 0, n - 1));
    }

    public static int quickSortForMedian(int[] a, int left, int right){
        int pivot = partition(a, left, right);
        if(pivot == a.length/2){
            return a[pivot];
        }else if(pivot < a.length/2){
            return quickSortForMedian(a, pivot + 1, right);
        }else{
            return quickSortForMedian(a, left, pivot - 1);
        }

    }
    public static int partition(int[] a, int left, int right){
        int pivot = a[right];
        int j = left -1;
        for(int i = left; i < right; i++){
            if(a[i] < pivot){
                swap(a, i, ++j);
            }
        }
        swap(a, right, j+1);
        return j+1;
    }
    public static void swap(int[] a, int left, int right){
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
