package challenges.warmup_sorting.utopian_tree;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.util.*;

public class Solution {
    public static int solve(int n){
        if( n == 0){
            return 1;
        }else if(n % 2 == 0){
            return solve(n-1) +1;
        }else{
            return solve(n-1) * 2;
        }

    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i =0; i < N; i++){
            int result = solve(sc.nextInt());
            System.out.println(result);
        }
    }
}
