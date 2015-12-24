import java.io.*;
import java.util.*;

public class Solution {
    public static final int M1 = 10000009;
    public static final int M2 = 10000007;
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
        String s = sc.next();
        int n = s.length();
        int b1 = 44;
        int b2 = 167;
        long[] p1 = new long[n+1];
        long[] p2 = new long[n+1];
        long[] h1 = new long[n+1];
        long[] h2 = new long[n+1];
        p1[0] = 1;
        p2[0] = 1;
        for(int i = 1; i <= n; i++){
            p1[i] = (b1 * p1[i-1]) % M1;
            p2[i] = (b2 * p2[i-1]) % M2;
        }
        h1[0] = 0;
        h2[0] = 0;
        for(int i = 1; i <= n; i++){
            h1[i] = (b1 * h1[i-1] + (s.charAt(i-1) - 'a') + 1 ) % M1;
            h2[i] = (b2 * h2[i-1] + (s.charAt(i-1) - 'a') + 1 ) % M2;
        }

        int Q = sc.nextInt();
        for(int i = 0; i < Q; i++){
            int l1 = sc.nextInt();
            int r1 = sc.nextInt();
            int l2 = sc.nextInt();
            int r2 = sc.nextInt();
            if(r1 - l1 == r2 - l2){
                int len = r1 - l1 + 1;
                long res1 = (h1[r1] - (h1[l1-1] * p1[len]) % M1 + M1) % M1;
                long res2 = (h2[r1] - (h2[l1-1] * p2[len]) % M2 + M2) % M2;
                long res3 = (h1[r2] - (h1[l2-1] * p1[len]) % M1 + M1) % M1;
                long res4 = (h2[r2] - (h2[l2-1] * p2[len]) % M2 + M2) % M2;
                if(res1 == res3 && res2 == res4){
                    pw.println("YES");
                }else{
                    pw.println("NO");
                }
            }else{
                pw.println("NO");
            }
        }

    }


}