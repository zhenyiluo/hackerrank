package challenges.dynamicProgramming;

/**
 * Created by Eric on 15-3-17.
 */

import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            System.out.println(solve(a, n, k));
        }
    }
    public static int solve(int[] a , int n, int k){
        boolean[] sum = new boolean[k+1];
        sum[0] = true;
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < n; i++){
            hs.add(a[i]);
        }
        for(int i = 0; i < k; i++){
            if(sum[i]){
                for(int item : a){
                    if(item + i <= k){
                        sum[item +i] = true;
                    }
                }
            }
        }
        for(int i = k; i>= 0; i--){
            if(sum[i]){
                return i;
            }
        }
        return 0;
    }
}
