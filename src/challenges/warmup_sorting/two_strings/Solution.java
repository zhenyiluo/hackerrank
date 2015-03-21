package challenges.warmup_sorting.two_strings;

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
            String A = sc.next();
            String B = sc.next();
            boolean flag = false;
            for(char c = 'a'; c <= 'z' && !flag; c++){
                if(A.indexOf(c) != -1 && B.indexOf(c) != -1){
                    flag = true;
                }
            }
            if(flag){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}