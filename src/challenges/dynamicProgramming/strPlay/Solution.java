package challenges.dynamicProgramming.strPlay;

/**
 * Created by Zhenyi Luo on 15-3-17.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    public static int solve(String s){
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i = 0; i < len; i++){
            dp[i][i] = 1;
        }
        for(int l = 2; l <= len; l++){
            for(int i = 0; i < len - l +1; i++){
                int j = i + l - 1;
                if(s.charAt(i) == s.charAt(j)){
                    if(l == 2){
                        dp[i][j] = 2;
                    }else{
                        dp[i][j] = 2 + dp[i+1][j-1];
                    }
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        int max = 0;
        for(int i = 0; i < len-1; i++){
            max = Math.max(dp[0][i] * dp[i+1][len-1], max);
        }
        return max;
    }
}