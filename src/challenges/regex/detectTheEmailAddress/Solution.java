package challenges.regex.detectTheEmailAddress;

/**
 * Created by Zhenyi Luo on 15-3-31.
 */

import java.util.Scanner;
import java.util.TreeSet;
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
        solve(N, in);
    }

    public static void solve(int n, String[] in){
        Pattern pattern = Pattern.compile("([\\w.]+@[\\w.]+[.](com|in|org))([^\\w]|$)");
        TreeSet<String> ts = new TreeSet<String>();
        for(int i = 0; i < n; i++){
            Matcher matcher = pattern.matcher(in[i]);
            while(matcher.find()){
                ts.add(matcher.group(1));
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(String s : ts){
            sb.append(s + ";");
        }
        if(sb.length() > 0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}