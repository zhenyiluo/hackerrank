package challenges.regex.detectTheDomainName;

/**
 * Created by Zhenyi Luo on 15-4-1.
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;

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

    public static void solve(int N, String[] in){
        Pattern pattern = Pattern.compile("https?://([\\da-z\\.-]+)[/\"\\?]");
        TreeSet<String> ts = new TreeSet<String>();
        for(int i = 0; i < N; i++){
            Matcher matcher = pattern.matcher(in[i]);
            while(matcher.find()){
                String s = matcher.group(1);
                if(s.startsWith("www.") ||s.startsWith("ww2.")){
                    s = s.substring(4);
                }
                if(s.contains(".")){
                    ts.add(s);
                }
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(String s : ts){
            sb.append(s + ";");
        }
        if(sb.length() >0){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }
}