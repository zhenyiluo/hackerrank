package challenges.warmup_sorting.filling_jars;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long result = 0;
        for(int i = 0; i < M; i++){
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = sc.nextLong();
            result += (b-a+1)*k;
        }
        System.out.println(result/N);
    }
}