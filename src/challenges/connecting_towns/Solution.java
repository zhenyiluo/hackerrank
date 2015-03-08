package challenges.connecting_towns;

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
            int N = sc.nextInt();
            int result = 1;
            for(int j = 0; j < N-1; j++){
                result *= sc.nextInt();
                result %= 1234567;
            }
            System.out.println(result);
        }
    }
}
