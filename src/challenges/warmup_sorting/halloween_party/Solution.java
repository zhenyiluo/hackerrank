package challenges.warmup_sorting.halloween_party;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T  = sc.nextInt();
        for(int i = 0; i < T; i++){
            long N = sc.nextLong();
            if(N % 2 == 0){
                System.out.println(N/2 * N/2);
            }else{
                System.out.println(N/2 * (N/2 +1));
            }
        }
    }
}