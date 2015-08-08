import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N ;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(N, a));
    }
    private static long solve(int N, int[] a){
        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += a[i];
        }
        return sum;
    }
}