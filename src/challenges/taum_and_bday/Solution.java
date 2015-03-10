package challenges.taum_and_bday;

/**
 * Created by Eric on 15-3-9.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            long B = sc.nextLong();
            long W = sc.nextLong();
            long X = sc.nextLong();
            long Y = sc.nextLong();
            long Z = sc.nextLong();
            long result = solve(B,W,X,Y,Z);
            System.out.println(result);
        }
    }
    public static long solve(long B, long W, long X, long Y, long Z){
        boolean flag = true; //X is smaller
        if(X > Y){
            flag = false;
        }
        long diff = Math.max(X,Y) - Math.min(X, Y);
        if(diff < Z){
            return B * X + W * Y;
        }else{
            if(flag){
                return B * X + W * (X + Z);
            }else{
                return B * (Y + Z) + W * Y;
            }
        }
    }
}