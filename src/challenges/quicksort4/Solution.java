package challenges.quicksort4;

import java.util.Scanner;

/**
 * Created by Eric on 15-3-11.
 */
public class Solution {
    static int countQuickSort =0;
    public static int insertionSort(int[] A){
        int count = 0;
        for(int i = 1; i < A.length; i++){
            int value = A[i];
            int j = i - 1;
            while(j >= 0 && A[j] > value){
                A[j + 1] = A[j];
                j = j - 1;
                count++;
            }
            A[j + 1] = value;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
        }
        int[] tmp = ar.clone();
        int countInsertionSort = insertionSort(tmp);
        quicksort(ar, 0, n-1);
        System.out.println(countInsertionSort - countQuickSort);
    }

    public static void quicksort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int pivot = partition(a, left, right);
        quicksort(a, left, pivot-1);
        quicksort(a, pivot+1, right);

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
        countQuickSort++;
        int tmp = a[left];
        a[left] = a[right];
        a[right] = tmp;
    }
}
