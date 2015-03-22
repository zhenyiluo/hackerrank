package challenges.numberTheory.restaurant;

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
            int l = sc.nextInt();
            int b = sc.nextInt();
            int g = gcd(l, b);
            System.out.println(l*b/(g*g));
        }
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
}