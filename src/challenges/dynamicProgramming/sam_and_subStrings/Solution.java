package challenges.dynamicProgramming.sam_and_subStrings;

/**
 * Created by Zhenyi Luo on 15-3-19.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    public static long solve(String s){
        final long mod = 1000000007;
        long cur_sum = 0;
        long total_sum = 0;
        for(int i = 0; i < s.length(); i++){
            cur_sum = (cur_sum * 10 + (s.charAt(i) - '0') * (i+1)) % mod;
            total_sum = (total_sum + cur_sum) % mod;
        }
        return total_sum;
    }
}