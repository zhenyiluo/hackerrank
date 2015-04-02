package challenges.regex.detectHtmlLinks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Zhenyi Luo on 15-4-1.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        String[] s = new String[N];
        for(int i = 0; i < N; i++){
            s[i] = sc.nextLine();
        }
        solve(N, s);
    }

    public static void solve(int n, String[] s){
        Pattern pattern = Pattern.compile("<a href=\"([^\"]+)\"(.*?>([^<]+)<)?");
        for(int i = 0; i < n; i++){
            Matcher matcher = pattern.matcher(s[i]);
            while(matcher.find()){
                if(matcher.group(3)!= null && matcher.group(3).trim().length() != 0){
                    System.out.println(matcher.group(1) + "," + matcher.group(3).trim());
                }else{
                    System.out.println(matcher.group(1) + ",");
                }
            }
        }
    }
}
