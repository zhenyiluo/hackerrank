package challenges.warmup_sorting.the_love_letter_mystery;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String s = sc.next();
            int result = solve(s);
            System.out.println(result);
        }
    }
    public static int solve(String s){
        int len = s.length();
        int result = 0;
        for(int i = 0; i < len/2; i++){
            result += Math.abs(s.charAt(i) - s.charAt(len - i -1));
        }
        return result;
    }
}