import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        solve(N, a);
    }
    
    private static void solve(int N, int[] a){
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int total = 0;
        for(int i = 0; i < N; i++){
            if(a[i] > 0){
                count1 ++;
            }else if(a[i] < 0){
                count2 ++;
            }else{
                count3 ++;
            }
        }
        total = count1 + count2 + count3;
       System.out.println((double) count1 / total);
       System.out.println((double) count2 / total);
       System.out.println((double) count3 / total);
    }
}