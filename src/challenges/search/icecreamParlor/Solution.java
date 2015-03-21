package challenges.search.icecreamParlor;

/**
 * Created by Zhenyi Luo on 15-3-21.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            solve(m, n, a);
        }
    }
    public static void solve(int m, int n, int[] a){
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                if(a[i] + a[j] == m){
                    System.out.println((i+1) + " " + (j+1));
                    return;
                }
            }
        }
    }
}