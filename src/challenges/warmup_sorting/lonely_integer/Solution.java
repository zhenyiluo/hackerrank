package challenges.warmup_sorting.lonely_integer;

/**
 * Created by Zhenyi Luo on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < N; i++){
            int n = sc.nextInt();
            if(hs.contains(n)){
                hs.remove(n);
            }else{
                hs.add(n);
            }
        }
        System.out.println(hs.iterator().next());
    }
}