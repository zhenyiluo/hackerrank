package challenges.dynamicProgramming.stringReduction;

/**
 * Created by Eric on 15-3-21.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String s = sc.next();
            System.out.println(solve(s));
        }
    }
    public static int solve(String s){
        int n = s.length();
        if(n <= 1){
            return n;
        }
        if(allTheSame(s)){
            return n;
        }
        int[] count = new int[3];
        for(int i = 0; i < n; i++){
            count[s.charAt(i)- 'a']++;
        }
        if(count[0] % 2 == 0 && count[1] % 2 == 0 && count[2] % 2 == 0){
            return 2;
        }
        if(count[0] % 2 != 0 && count[1] % 2 != 0 && count[2] % 2 != 0){
            return 2;
        }
        return 1;
    }
    public static boolean allTheSame(String s){
        int n = s.length();
        for(int i = 1; i < n; i++){
            if(s.charAt(i) != s.charAt(i-1)){
                return false;
            }
        }
        return true;
    }
}