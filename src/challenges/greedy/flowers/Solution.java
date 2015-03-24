package challenges.greedy.flowers;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        Integer[] a = new Integer[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(n, k, a));
    }
    public static int solve(int n, int k, Integer[] a){
        Arrays.sort(a, Collections.reverseOrder());
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += (i/k + 1) * a[i];
        }
        return sum;
    }
}