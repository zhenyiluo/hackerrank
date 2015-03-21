package challenges.warmup_sorting.chocolate_feast;

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
            int N = sc.nextInt();
            int C = sc.nextInt();
            int M = sc.nextInt();
            int result = solve(N, C, M);
            System.out.println(result);
        }
    }
    public static int solve(int N, int C, int M){
        int result = N/C;
        int convert = result;
        while(convert >= M){
            result += convert / M;
            convert = convert / M + convert % M;
        }
        return result;
    }
}
