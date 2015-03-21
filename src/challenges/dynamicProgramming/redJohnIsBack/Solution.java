package challenges.dynamicProgramming.redJohnIsBack;

import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-18.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] a = new int[41];
        solve(a);
        for(int i = 0; i < t; i++){
            int num = sc.nextInt();
            System.out.println(getPrimeNumber(a[num]));
        }
    }
    public static void solve(int[] a){
        int n = 40;
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;
        for(int i = 4; i<= n; i++){
            a[i] = a[i-1] + a[i-4];
        }
    }
    public static int getPrimeNumber(int n){
        if(n <2){
            return 0;
        }
        if(n ==2){
            return 1;
        }
        int count = 1;
        for(int i = 3; i <= n; i++){
            if(isPrime(i)){
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int n){
        for(int i = 2; i<= (int)Math.sqrt(n); i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
}
