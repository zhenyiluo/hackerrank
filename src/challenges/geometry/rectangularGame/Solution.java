package challenges.geometry.rectangularGame;

/**
 * Created by Zhenyi Luo on 15-3-27.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long minA = Long.MAX_VALUE;
        long minB = Long.MAX_VALUE;
        for(int i = 0; i < N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            minA = Math.min(minA, a);
            minB = Math.min(minB, b);
        }
        System.out.println(minA * minB);
    }
}