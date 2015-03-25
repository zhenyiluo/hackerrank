package challenges.greedy.largest_permutation;

/**
 * Created by Zhenyi Luo on 15-3-25.
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
        if(k >= n){
            Arrays.sort(a);
            for(int i = n-1; i >= 0; i--){
                System.out.print(a[i] + " ");
            }
        }else{
            solve(n, k, a);
            for(int i = 0; i < n; i++){
                System.out.print(a[i] + " ");
            }
        }
        System.out.println();
    }
    public static void solve(int n, int k, int[] a){
        for(int i = 0; i < n-1 && k > 0; i++){
            if(a[i] != n-i){
                for(int j = i+1; j < n; j++){
                    if(a[j] == n-i){
                        swap(a, i, j);
                        k--;
                        break;
                    }
                }
            }
        }
    }
    public static void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}