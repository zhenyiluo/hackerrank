package challenges.warmup_sorting.quicksort3;

/**
 * Created by Eric on 15-3-10.
 */
import java.util.*;

public class Solution {
    static int N;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
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
        printArray(a, 0, N-1);
        quicksort(a, left, pivot-1);
        quicksort(a, pivot+1, right);

    }
    public static void printArray(int[] a, int left, int right){
        for(int i = left; i <= right; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
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