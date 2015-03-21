package challenges.dynamicProgramming.billBoards;

/**
 * Created by Zhenyi Luo on 15-3-21.
 */
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n+1];
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(a, n, k));
    }
    public static long solve(int[] a, int n, int k){
        long[] dp = new long[n+1];
        dp[0] = 0;
        for(int i = 1; i <= k; i++){
            dp[i] = dp[i-1] + a[i];
        }
        for(int i = k+1; i <= n; i++){
            dp[i] = dp[i-1];
            long sum = 0;
            for(int j = i-2; j >= i -k -1; j--){
                sum += a[j+2];
                dp[i] = Math.max(dp[i], sum + dp[j]);
            }
        }

        return dp[n];
    }
}