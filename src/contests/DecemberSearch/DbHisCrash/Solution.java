import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNext()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();
    }
    
    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            if(val == 1){
                cnt1++;
            }else if(val == 2){
                cnt2++;
            }else{
                cnt3++;
            }
        }
        int max = Math.max(cnt3, Math.max(cnt1, cnt2));
        pw.println(n - max);
    }
}