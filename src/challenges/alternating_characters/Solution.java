package challenges.alternating_characters;

/**
 * Created by Eric on 15-3-8.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String s = sc.next();
            int result = solve(s);
            System.out.println(result);
        }
    }
    public static int solve(String s){
        int len = s.length();
        if(len <= 1){
            return 0;
        }
        int result = 0;
        char prev = s.charAt(0);
        for(int i =1 ; i < len; i++){
            char c = s.charAt(i);
            if(c == prev){
                result ++;
            }else{
                prev = c;
            }
        }
        return result;
    }
}