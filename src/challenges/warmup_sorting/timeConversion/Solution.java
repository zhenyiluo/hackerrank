import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    
    private static String solve(String s){
        StringBuilder sb = new StringBuilder();
        if(s.contains("AM")){
            if(s.substring(0,2).equals("12")){
                sb.append("00");
            }else{
                sb.append(s.substring(0,2));
            }
            sb.append(s.substring(2,s.length() - 2));
        }else{
            if(s.substring(0,2).equals("12")){
                sb.append(s.substring(0,2));
            }else{
                Integer n = Integer.parseInt(s.substring(0,2));
                n += 12;
                sb.append(String.valueOf(n));
            }
            sb.append(s.substring(2,s.length() - 2));
        }
        return sb.toString();
    }
}