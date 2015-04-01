package challenges.regex.findAWord;

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
        String[] in = new String[N];
        for(int i = 0; i < N; i++){
            in[i] = sc.nextLine();
        }
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String word = sc.next();
            solve(word, N, in);
        }
    }

    public static void solve(String word, int n, String[] in){
        Pattern pattern = Pattern.compile("\\b" + word + "\\b");
        int count = 0;
        for(int i = 0; i < n; i++){
            Matcher matcher = pattern.matcher(in[i]);
            while(matcher.find()){
                count++;
            }
        }
        System.out.println(count);
    }
}