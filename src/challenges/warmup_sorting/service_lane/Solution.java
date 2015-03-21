package challenges.warmup_sorting.service_lane;

/**
 * Created by Zhenyi Luo on 15-3-9.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int[] arr = new int[N];
        int[][] cases = new int[T][2];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        for(int i = 0; i < T; i++){
            cases[i][0] = sc.nextInt();
            cases[i][1] = sc.nextInt();
        }
        for(int i = 0; i < T; i++){
            int result = 3;
            for(int j = cases[i][0]; j <= cases[i][1]; j++){
                result = Math.min(result, arr[j]);
            }
            System.out.println(result);
        }
    }
}