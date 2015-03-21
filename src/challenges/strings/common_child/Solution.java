package challenges.strings.common_child;

/**
 * Created by Zhenyi Luo on 15-3-14.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(lcs(a,b));
    }
    public static int lcs(String a, String b){
        int n = a.length();
        int[][] dp = new int[n+1][n+1];
        dp[0][0] = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
}