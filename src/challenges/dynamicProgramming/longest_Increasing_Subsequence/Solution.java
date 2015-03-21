package challenges.dynamicProgramming.longest_Increasing_Subsequence;

/**
 * Created by Zhenyi Luo on 15-3-17.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(a));
    }
    public static int solve(int[] a){
        int n = a.length;
        int[] c = new int[n+1];
        c[0] = -1;
        c[1] = a[0];
        int len = 1;
        for(int i = 1; i < n; i++){
            int j = binarySearch(c, len, a[i]);
            c[j] = a[i];
            if(j > len){
                len = j;
            }
        }
        return len;
    }
    public static int binarySearch(int[] a, int len, int n){
        int left = 0;
        int right = len;
        while(left <= right){
            int mid = (left+right)/2;
            if(n > a[mid]){
                left = mid+1;
            }else if(n < a[mid]){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return left;
    }
}