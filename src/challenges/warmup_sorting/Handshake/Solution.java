package challenges.warmup_sorting.Handshake;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i= 0; i < T; i++){
            int N = sc.nextInt();
            System.out.println(N*(N-1)/2);
        }
    }
}