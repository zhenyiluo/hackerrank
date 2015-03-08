package challenges.flipping_bits;

/**
 * Created by Eric on 15-3-8.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++){
            long result = 0;
            long mask = 0x00000000ffffffffL;
            result = ~(sc.nextLong());
            result &= mask;
            System.out.println(result);
        }
    }
}