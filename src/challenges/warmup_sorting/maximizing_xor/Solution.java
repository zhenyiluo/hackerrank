package challenges.warmup_sorting.maximizing_xor;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt();
        int R = sc.nextInt();
        int result = solve(L, R);
        System.out.println(result);
    }

    public static int solve(int L , int R){
        int result = 0;
        for(int A = L; A <= R-1; A++){
            for(int B = A+1; B <= R; B++){
                result = Math.max(result, A ^ B);
            }
        }
        return result;
    }
}
