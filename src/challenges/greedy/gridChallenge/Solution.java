package challenges.greedy.gridChallenge;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            char[][] c = new char[n][n];
            for(int j = 0; j < n; j++){
                c[j] = sc.next().toCharArray();
            }
            System.out.println(solve(n, c));
        }
    }
    public static String solve(int n, char[][] c){
        if(n == 1){
            return "YES";
        }
        boolean result = true;
        for(int i = 0; i < n; i++){
            Arrays.sort(c[i]);
        }
        boolean flag = true;
        for(int j = 0; j < n && flag; j++){
            for(int i = 1; i < n && flag; i++){
                if(c[i][j] < c[i-1][j]){
                    result = false;
                    flag = false;
                }
            }
        }
        if(result){
            return "YES";
        }else{
            return "NO";
        }
    }
}