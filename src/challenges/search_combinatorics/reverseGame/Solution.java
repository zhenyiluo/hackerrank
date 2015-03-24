package challenges.search_combinatorics.reverseGame;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(solve(n, k));
        }
    }
    public static int solve(int n, int k){
        int result;
        if(k >= n/2){
            result = (n-1-k) * 2;
        }else{
            result = 1 + k * 2;
        }
        return result;
    }
}