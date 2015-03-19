package challenges.dynamicProgramming.stockMax;

/**
 * Created by Eric on 15-3-18.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int j = 0; j < T; j++){
            int N = sc.nextInt();
            int[] a = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = sc.nextInt();
            }
            System.out.println(solve(a));
        }
    }
    public static long solve(int[] a){
        int n = a.length;
        if(n == 1){
            return 0;
        }
        int[] max = new int[n];
        max[n-1] = a[n-1];
        for(int i = n-2; i>= 0; i--){
            max[i] = Math.max(max[i+1], a[i]);
        }
        long profit = 0;
        for(int i = 0; i < n; i++){
            profit += max[i] - a[i];
        }
        return profit;
    }
}