package challenges.warmup_sorting.angry_professor;

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
            int K = sc.nextInt();
            int count = 0;
            for(int j = 0; j < N; j++){
                if(sc.nextInt() <= 0){
                    count++;
                }
            }
            if(count >= K){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }
        }
    }
}