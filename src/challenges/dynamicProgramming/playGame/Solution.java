package challenges.dynamicProgramming.playGame;

/**
 * Created by Eric on 15-3-18.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a));
        }
    }

    public static long solve(int[] a) {
        int n = a.length;
        if (n <= 3) {
            long result = 0;
            for (int i = 0; i < n; i++) {
                result += a[i];
            }
            return result;
        }
        long[] dp = new long[n];
        dp[n - 1] = a[n - 1];
        dp[n - 2] = dp[n - 1] + a[n - 2];
        dp[n - 3] = dp[n - 2] + a[n - 3];
        long[] sum = new long[n];
        sum[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sum[i] += sum[i + 1] + a[i];
        }
        for (int i = n - 4; i >= 0; i--) {
            dp[i] = max(a[i] + sum[i + 1] - dp[i + 1],
                    a[i] + a[i + 1] + sum[i + 2] - dp[i + 2],
                    a[i] + a[i + 1] + a[i + 2] + sum[i + 3] - dp[i + 3]);
        }
        return dp[0];
    }

    public static long max(long l1, long l2, long l3) {
        long result = Math.max(l1, l2);
        return Math.max(result, l3);
    }
}

