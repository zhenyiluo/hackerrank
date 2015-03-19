package challenges.dynamicProgramming.legoBlocks;

import java.util.Scanner;

/**
 * Created by Eric on 15-3-19.
 */
public class Solution {
    final static int MOD = 1000000007;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            System.out.println(solve(n, m));
        }
    }
    public static long solve(int n, int m){
        long[] a = new long[1001];
        a[1] = 1;
        a[2] = 2;
        a[3] = 4;
        a[4] = 8;
        for(int i = 5; i<=m; i++){
            a[i] = (a[i-1] + a[i-2] + a[i-3] + a[i-4]) % MOD;
        }
        long[] sum = new long[1001];
        for(int i = 1; i<= m; i++){
            sum[i] = pow(a[i], n);
        }
        long[] dp = new long[1001];
        dp[0] = 0;
        for(int i = 1; i<=m; i++){
            dp[i] = sum[i];
            for(int j = 1; j < i; j++){
                dp[i] -= dp[j] * sum[i-j];
                dp[i] = (dp[i] % MOD + MOD) % MOD;
            }
        }
        return dp[m];
    }

    public static long pow(long a, int n){
        if(n == 0) return 1;
        if(n == 1) return a;
        long result = a;
        for(int i = 2; i<= n; i++){
            result *= a;
            result %= MOD;
        }
        return result;
    }

}
