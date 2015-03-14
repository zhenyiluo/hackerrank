package challenges.warmup_sorting.sherlock_and_the_beast;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            String result = solve(N);
            System.out.println(result);
        }
    }
    public static String solve(int N){
        if(N < 3){
            return "-1";
        }

        for(int x = N/3; x >= 0; x--){
            int tmp = N - 3*x;
            if(tmp % 5 == 0){
                int y = tmp/5;
                StringBuilder sb = new StringBuilder("");
                for(int i = 0; i < x; i++){
                    sb.append("555");
                }
                for(int i = 0; i < y; i++){
                    sb.append("33333");
                }
                return sb.toString();
            }
        }
        return "-1";
    }

}