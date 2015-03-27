package challenges.geometry.findPoint;

/**
 * Created by Zhenyi Luo on 15-3-26.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int px = sc.nextInt();
            int py = sc.nextInt();
            int qx = sc.nextInt();
            int qy = sc.nextInt();
            int x = 2 * qx - px;
            int y = 2 * qy - py;
            System.out.println(x + " " + y);
        }
    }
}