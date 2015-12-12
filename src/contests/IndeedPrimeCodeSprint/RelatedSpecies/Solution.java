import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            long[] a = new long[N];
            long[] b = new long[N];
            for(int j = 0; j < N ;j++){
                a[j] = sc.nextLong();
            }
            for(int j = 0; j < N ;j++){
                b[j] = sc.nextLong();
            }
            if(solve(a, b, N)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
        
    }
    
    private static boolean solve(long[] a, long[] b, int N){
        long prev = -1;
        long min;
        long max;
        for(int i = 0; i < N; i++){
            min = Math.min(a[i], b[i]);
            max = Math.max(a[i], b[i]);
            if(max < prev){
                return false;
            }
            
            if(min >= prev){
                prev = min;
            }else{
                prev = max;
            }
        }
        return true;
    }
}