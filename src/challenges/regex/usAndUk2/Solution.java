package challenges.regex.usAndUk2;

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
            String sub = sc.next();
            solve(s, sub, N);
        }
    }

    public static void solve(String[] s, String sub, int n){
        String[] tmp = sub.split("our");

        Pattern pattern;
        if(tmp.length ==1){
            pattern = Pattern.compile(tmp[0] + "(our|or)" + "([^\\w]|$)");
        }else{
            pattern = Pattern.compile(tmp[0] + "(our|or)" + tmp[1] + "([^\\w]|$)");
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            Matcher matcher = pattern.matcher(s[i]);
            while(matcher.find()){
                count++;
            }
        }
        System.out.println(count);
    }
}