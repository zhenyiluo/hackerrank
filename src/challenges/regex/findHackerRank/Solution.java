package challenges.regex.findHackerRank;

/**
 * Created by Zhenyi Luo on 15-3-29.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            System.out.println(solve(s));
        }
    }
    public static int solve(String s){
        if(s.matches("hackerrank.*") && s.matches(".*hackerrank")){
            return 0;
        }else if(s.matches("hackerrank.*")){
            return 1;
        }else if(s.matches(".*hackerrank")){
            return 2;
        }else{
            return -1;
        }
    }
}