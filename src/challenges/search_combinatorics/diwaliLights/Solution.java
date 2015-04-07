package challenges.search_combinatorics.diwaliLights;

/**
 * Created by Zhenyi Luo on 15-4-6.
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
            solve(N);
        }
    }

    public static void solve(int N){
        long ret = 1;
        for(int i = 0; i < N; i++){
            ret = (ret * 2) % 100000;
        }
        ret = (ret - 1) % 100000;
        System.out.println(ret);
    }
}