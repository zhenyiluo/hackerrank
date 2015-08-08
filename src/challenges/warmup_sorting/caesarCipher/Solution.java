import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        int K = sc.nextInt();
        System.out.println(solve(s, K));
    }
    
    private static String solve(String s, int K){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c >= 'a'  && c <= 'z'){
                int n = (c - 'a' + K) % 26;
                char tmp = (char)(n + 'a');
                sb.append(tmp);
            }else if(c >= 'A' && c <= 'Z'){
                int n = (c - 'A' + K) % 26;
                char tmp = (char) (n + 'A');
                sb.append(tmp);
            }else{
                sb.append(c);                
            }
        }
        return sb.toString();
    }
}