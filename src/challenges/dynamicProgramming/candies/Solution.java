package challenges.dynamicProgramming.candies;

/**
 * Created by Zhenyi Luo on 15-3-18.
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
    public static long solve(int[] a){
        int n = a.length;
        if(n == 1){
            return 1;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 0;
        for(int i = 1; i < n;i++){
            if(a[i] > a[i-1]){
                left[i] = left[i-1] +1;
            }else{
                left[i] = 0;
            }
        }
        right[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            if(a[i] > a[i+1]){
                right[i] = right[i+1] +1;
            }else{
                right[i] = 0;
            }
        }
        long result = n;
        for(int i = 0; i < n; i++){
            result += Math.max(left[i], right[i]);
        }
        return result;
    }
}