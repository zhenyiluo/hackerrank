package challenges.warmup_sorting.find_digits;

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
            long N = sc.nextLong();
            int result = solve(N);
            System.out.println(result);
        }
    }
    public static int solve(long N){
        int result = 0;
        long tmp = N;
        while(tmp > 0){
            long digit = tmp % 10;
            if(digit > 0 && N % digit == 0){
                result ++;
            }
            tmp /= 10;
        }
        return result;
    }
}