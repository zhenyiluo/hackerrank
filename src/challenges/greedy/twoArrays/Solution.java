package challenges.greedy.twoArrays;

/**
 * Created by Zhenyi Luo on 15-3-24.
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
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for(int j = 0; j< n; j++){
                a[j]=  sc.nextInt();
            }
            for(int j = 0; j < n; j++){
                b[j] = sc.nextInt();
            }
            System.out.println(solve(n, k, a, b));
        }
    }
    public static String solve(int n, int k, int[] a, int[] b){
        Arrays.sort(a);
        Arrays.sort(b);
        String result = "YES";
        boolean flag = true;
        for(int i = 0; i < n && flag; i++){
            if(a[i] + b[n-i-1] < k){
                flag = false;
                result = "NO";
            }
        }
        return result;
    }
}