import java.io.*;
import java.util.*;
import java.io.PrintWriter;

public class Solution {

  public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        char[] c1 = new char[5];
        char[] c2 = new char[5];
        for(int i = 0; i < 5; i++){
            String s = sc.next();
            c1[i] = s.charAt(0);
            c2[i] = s.charAt(1);
        }
        if(solve(c1, c2)){
            pw.println("YES");
        }else{
            pw.println("NO");
        }
        sc.close();
        pw.flush();
        pw.close();
        
    }
    
    private static boolean solve(char[] c1, char[] c2){
        char prev = c2[0];
        for(int i = 1; i < 5; i++){
            if(c2[i] != prev){
                return false;
            }
        }
        
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 5; i++){
            hs.add(c1[i]);
        }
        if(hs.size() != 5){
            return false;
        }
        int cnt = 1;
        char[] arr = new char[]{'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
        for(int i = 0; i <= arr.length -5; i++){
            boolean flag = true;
            for(int j = 0; j < 5; j++){
                if(!hs.contains(arr[i+j])){
                    flag = false;
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}