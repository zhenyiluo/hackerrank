package challenges.warmup_sorting.manasa_and_stones;

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
            int n = sc.nextInt() -1;
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x == y){
                System.out.println(n*x);
            }else{
                int a = Math.min(x, y);
                int b = Math.max(x, y);
                StringBuilder sb = new StringBuilder("");
                for(int num = n*a; num <= n*b; num += b-a){
                    sb.append(num + " ");
                }
                System.out.println(sb.toString());
            }
        }
    }

}