package challenges.regex.ukAndUs;

/**
 * Created by Zhenyi Luo on 15-3-31.
 */
import java.io.*;
import java.util.*;
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
            String word = sc.next();
            word = word.substring(0, word.length() - 2);
            solve(N, s, word);
        }
    }
    public static void solve(int n, String[] s, String word){
        Pattern pattern = Pattern.compile(word + "(se|ze)");
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