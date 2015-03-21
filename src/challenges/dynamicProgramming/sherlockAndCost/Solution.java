package challenges.dynamicProgramming.sherlockAndCost;

/**
 * Created by Zhenyi Luo on 15-3-20.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a));
        }
    }
    public static int solve(int[] a){
        int n = a.length;
        if(n <= 1){
            return 0;
        }
        int[][] dp = new int[n][2];
        int[][] b = new int[n][2];
        for(int i = 0; i< n; i++){
            b[i][0] = 1;
            b[i][1] = a[i];
        }
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1; i< n; i++){
            for(int j = 0; j < 2; j++){
                dp[i][j] = Integer.MIN_VALUE;
                for(int k = 0; k < 2; k++){
                    dp[i][j] = Math.max(dp[i][j], Math.abs(b[i][j] - b[i-1][k]) + dp[i-1][k]);
                }
            }
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}