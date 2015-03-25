package challenges.greedy.boardCutting;

/**
 * Created by Zhenyi Luo on 15-3-25.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int m = sc.nextInt();
            int n = sc.nextInt();
            long[] a = new long[m-1];
            long[] b = new long[n-1];
            for(int j = 0; j < m-1; j++){
                a[j] = sc.nextLong();
            }
            for(int j = 0; j < n-1; j++){
                b[j] = sc.nextLong();
            }
            System.out.println(solve(m, n, a, b));
        }
    }
    public static long solve(int m, int n, long[] a, long[] b){
        final int modNum = 1000000007;
        long result = 0;
        int countA = 1;
        int countB = 1;
        Arrays.sort(a);
        Arrays.sort(b);
        int indexA = m-2;
        int indexB = n-2;
        while(indexA >= 0 && indexB >=0){
            if(a[indexA] > b[indexB]){
                result += (a[indexA--] * countB) % modNum;
                result %= modNum;
                countA++;
            }else{
                result += (b[indexB--] * countA) % modNum;
                result %= modNum;
                countB++;
            }
        }
        while(indexA >= 0){
            result += (a[indexA--] * countB) % modNum;
            result %= modNum;
            countA++;
        }
        while(indexB >= 0){
            result += (b[indexB--] * countA) % modNum;
            result %= modNum;
            countB++;
        }
        return result;
    }
}