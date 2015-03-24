package challenges.greedy.markAndToys;

/**
 * Created by Zhenyi Luo on 15-3-24.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(n, k, a));
    }
    public static int solve(int n, int k, int[] a){
        int result = 0;
        Arrays.sort(a);
        int index = 0;
        while(index < n && k - a[index] >=0){
            k -= a[index];
            index++;
            result++;
        }
        return result;
    }
}