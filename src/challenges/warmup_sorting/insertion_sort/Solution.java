package challenges.warmup_sorting.insertion_sort;

/**
 * Created by Eric on 15-3-12.
 */
import java.util.*;

public class Solution {

    public static long mergeAndCountInversions(int[] A, int start, int end){
        if(start>= end){
            return 0;
        }
        long count = 0;
        int mid = (start + end) /2;
        count += mergeAndCountInversions(A, start, mid);
        count += mergeAndCountInversions(A, mid + 1, end);
        count += mergeTwoLists(A, start, mid, end);
        return count;
    }

    public static long mergeTwoLists(int[] A, int start, int mid, int end){
        long count = 0;
        int[] left = Arrays.copyOfRange(A, start, mid+1);
        int[] right = Arrays.copyOfRange(A, mid + 1, end + 1);
        int leftIndex = 0;
        int rightIndex = 0;
        int index = start;
        int leftSize = left.length;
        int rightSize = right.length;
        while(leftIndex < leftSize && rightIndex < rightSize){
            if(left[leftIndex] > right[rightIndex]){
                count += leftSize - leftIndex;
                A[index] = right[rightIndex];
                index++;
                rightIndex++;
            }else{
                A[index] = left[leftIndex];
                index++;
                leftIndex++;
            }
        }
        for(; leftIndex < leftSize; leftIndex ++){
            A[index++] = left[leftIndex];
        }
        for(; rightIndex < rightSize; rightIndex ++){
            A[index++] = right[rightIndex];
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int[] ar = new int[n];
            for(int j=0;j<n;j++){
                ar[j]=sc.nextInt();
            }
            System.out.println(mergeAndCountInversions(ar, 0, n - 1));
        }
    }
}

