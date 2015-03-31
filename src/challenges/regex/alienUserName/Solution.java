package challenges.regex.alienUserName;

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
        solve(N, s);
    }

    public static void solve(int n, String[] s){
        Pattern pattern = Pattern.compile("^[_.][0-9]+[a-zA-Z]*_{0,1}$");
        for(int i = 0; i < n; i++){
            Matcher m = pattern.matcher(s[i]);
            if(m.find()){
                System.out.println("VALID");
            }else{
                System.out.println("INVALID");
            }
        }
    }
}