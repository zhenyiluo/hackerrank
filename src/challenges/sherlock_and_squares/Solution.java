package challenges.sherlock_and_squares;

/**
 * Created by Eric on 15-3-8.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            int a = (int) Math.sqrt(A);
            int b = (int) Math.sqrt(B);
            while(a*a < A){
                a++;
            }
            System.out.println(b-a+1);
        }
    }
}