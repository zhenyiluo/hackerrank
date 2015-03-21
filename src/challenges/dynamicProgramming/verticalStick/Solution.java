package challenges.dynamicProgramming.verticalStick;

/**
 * Created by Zhenyi Luo on 15-3-20.
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
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            System.out.println(String.format("%.2f", solve(a)));
        }
    }
    public static double solve(int[] a){
        int n = a.length;
        Arrays.sort(a);
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = n - i;
            int j = i-1;
            while(j >= 0 && a[j] == a[i]){
                list[i]++;
                j--;
            }
        }
//        list[0] = 1;
//        for(int i = 1; i < n; i++){
//            list[i] = a[i] > a[i-1] ? i+1 : list[i-1];
//        }
//        for(int i = 0; i < n; i++){
//            list[i] = n+1-list[i];
//        }
//        for(int i = 0; i< n; i++){
//            System.out.print(list[i] + " ");
//        }
        double result = 0;
        for(int num : list){
            result += 1.0 / (num+1);
        }
        result *= n+1;
        return result;
    }
}