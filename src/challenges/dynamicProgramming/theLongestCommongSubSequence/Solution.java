package challenges.dynamicProgramming.theLongestCommongSubSequence;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-17.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[n+1];
        int[] b = new int[m+1];
        for(int i = 1; i <= n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 1; i <= m; i++){
            b[i] = sc.nextInt();
        }
        ArrayList<Integer> result = solve(a, b);
        for(int num : result){
            System.out.print(num + " ");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<Integer> solve(int[] a, int[] b){
        int n = a.length-1;
        int m = b.length-1;
        ArrayList<Integer>[][] dp = new ArrayList[n+1][m+1];
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j] = new ArrayList();
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a[i] == b[j]){
                    dp[i][j].addAll(dp[i-1][j-1]);
                    dp[i][j].add(a[i]);
                }else{
                    if(dp[i-1][j].size() > dp[i][j-1].size()){
                        dp[i][j].addAll(dp[i-1][j]);
                    }else{
                        dp[i][j].addAll(dp[i][j-1]);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
