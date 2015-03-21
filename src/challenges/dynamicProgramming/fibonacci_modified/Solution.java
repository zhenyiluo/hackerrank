package challenges.dynamicProgramming.fibonacci_modified;

/**
 * Created by Zhenyi Luo on 15-3-18.
 */

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(solve(a, b, n));
    }
    public static BigInteger solve(int a, int b, int n){
        BigInteger aa = BigInteger.valueOf(a);
        BigInteger bb = BigInteger.valueOf(b);
        BigInteger cc = BigInteger.valueOf(0);
        for(int i = 2; i< n; i++){
            cc = bb.multiply(bb).add(aa) ;
            aa = bb;
            bb = cc;
        }
        return cc;
    }
}