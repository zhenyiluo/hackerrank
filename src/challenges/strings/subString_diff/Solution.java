package challenges.strings.subString_diff;

/**
 * Created by Eric on 15-3-15.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            String p= sc.next();
            String q = sc.next();
            System.out.println(solve(n, p, q));
        }
    }
    public static int solve(int n, String p, String q){
        int len = p.length();
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < len; i++){
            result = Math.max(result, solve(p, q, i, 0, n, len));
            result = Math.max(result, solve(p, q, 0, i, n, len));
        }
        return result;
    }
    public static int solve(String p, String q, int startX, int startY, int k, int len){
        int x = startX;
        int y = startY;
        int l = 0;
        int bad = 0;
        int result = 0;
        while(true){
            if ((x+l >= len) || (y+l >= len)){
                result = Math.max(result, l);
                break;
            }

            if(p.charAt(x+l) != q.charAt(y+l)){
                bad++;
            }

            if(bad > k){
                result = Math.max(result, l);
                while(p.charAt(x) == q.charAt(y)){
                    x++;
                    y++;
                    l--;
                }
                bad--;
                x++;
                y++;
            }else{
                l++;
            }
        }
        return result;
    }
}
