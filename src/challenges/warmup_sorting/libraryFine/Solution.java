import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int d1 = sc.nextInt();
        int m1 = sc.nextInt();
        int y1 = sc.nextInt();
        int d2 = sc.nextInt();
        int m2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println(solve(d1, m1, y1, d2, m2, y2));
    }
    
    private static int solve(int d1, int m1, int y1, int d2, int m2, int y2){
        if(y1 > y2){
            return 10000;
        }
        
        if(y1 < y2){
            return 0;
        }
        
        if(m1 < m2){
            return 0;
        }else if(m1 == m2){
            if(d1 <= d2){
                return 0;   
            }else{
                return 15 * (d1 - d2);
            }
        }else{
            return 500 * (m1 - m2);
        }
    }
}