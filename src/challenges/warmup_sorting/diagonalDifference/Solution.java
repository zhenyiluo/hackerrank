import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] a = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N;j++){
                a[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(solve(N, a));
    }
    
    private static long solve(int N, int[][] a){
        long sum1 = 0;
        long sum2 = 0;
        for(int i = 0; i < N; i++){
            sum1 += a[i][i];
            sum2 += a[i][N - i - 1];
        }
        return Math.abs(sum1 - sum2);    
    }
}