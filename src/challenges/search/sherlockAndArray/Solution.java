package challenges.search.sherlockAndArray;

/**
 * Created by Zhenyi Luo on 15-3-22.
 */

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
            System.out.println(solve(n, a));
        }
    }
    public static String solve(int n, int[] a){
        if(n == 1){
            return "YES";
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += a[i];
        }
        int tmp = a[0];
        for(int i = 1; i < n; i++){
            if(tmp *2 == (sum - a[i])){
                return "YES";
            }else if(tmp * 2 > sum - a[i]){
                return "NO";
            }else{
                tmp += a[i];
            }
        }
        return "NO";
    }
}