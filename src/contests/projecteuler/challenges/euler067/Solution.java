package contests.projecteuler.challenges.euler067;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for(int row = 0; row < N; row++){
                for(int col = 0; col <= row; col++){
                    arr[row][col] = sc.nextInt();
                }
            }
            int result = solve(arr);
            System.out.println(result);
        }
    }
    public static int solve(int[][] arr){
        int N = arr.length;
        for(int i= 1; i < N; i++){
            arr[i][0] = arr[i][0] + arr[i-1][0];
            arr[i][i] = arr[i][i] + arr[i-1][i-1];
        }
        for(int i = 2; i < N; i++){
            for(int j = 1; j < i; j++){
                arr[i][j] = arr[i][j] + Math.max(arr[i-1][j-1], arr[i-1][j]);
            }
        }
        int result = 0;
        for(int i = 0; i < N; i++){
            result = Math.max(result, arr[N-1][i]);
        }
        return result;
    }
}