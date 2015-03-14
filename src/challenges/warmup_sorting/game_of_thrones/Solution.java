package challenges.warmup_sorting.game_of_thrones;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    public static String solve(String s){
        int len = s.length();
        int mask = 0;
        for(int i = 0; i < len; i++){
            mask ^= (1 << (s.charAt(i) - 'a'));
        }
        if(Integer.bitCount(mask) <=1){
            return "YES";
        }else{
            return "NO";
        }
    }
}