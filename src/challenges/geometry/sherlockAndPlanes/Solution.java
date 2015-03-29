package challenges.geometry.sherlockAndPlanes;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            long x1 = sc.nextLong();
            long y1 = sc.nextLong();
            long z1 = sc.nextLong();
            long x2 = sc.nextLong();
            long y2 = sc.nextLong();
            long z2 = sc.nextLong();
            long x3 = sc.nextLong();
            long y3 = sc.nextLong();
            long z3 = sc.nextLong();
            long x4 = sc.nextLong();
            long y4 = sc.nextLong();
            long z4 = sc.nextLong();
            System.out.println(solve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4));
        }
    }

    public static String solve(long x1, long y1, long z1, long x2, long y2, long z2, long x3, long y3, long z3, long x4, long y4, long z4){
        if( (x4-x1)*(y2-y1)*(z3-z1) + (y4-y1)*(z2-z1)*(x3-x1) + (z4-z1)*(x2-x1)*(y3-y1)
                -(z4-z1)*(y2-y1)*(x3-x1) - (y4-y1)*(x2-x1)*(z3-z1) - (x4-x1)*(z2-z1)*(y3-y1) ==0){
            return "YES";
        }else{
            return "NO";
        }
    }
}