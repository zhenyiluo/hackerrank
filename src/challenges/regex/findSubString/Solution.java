package challenges.regex.findSubString;

/**
 * Created by Zhenyi Luo on 15-3-31.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] s = new String[N];
        for(int i = 0; i < N; i++){
            s[i] = sc.nextLine();
        }
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String substring = sc.next();
            solve(substring, s);
        }
    }
    public static void solve(String substring, String[] s){
        Pattern p = Pattern.compile("\\w" + substring + "\\w");
        int count = 0;
        for(int i = 0; i < s.length; i++){
            Matcher m = p.matcher(s[i]);
            while(m.find()){
                count ++;
            }
        }
        System.out.println(count);
    }
}