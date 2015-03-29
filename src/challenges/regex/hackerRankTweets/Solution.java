package challenges.regex.hackerRankTweets;

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
        int count = 0;
        for(int i = 0; i < N; i++){
            String s = sc.nextLine();
            s = s.toLowerCase();
            if(s.contains("hackerrank")){
                count++;
            }
        }
        System.out.println(count);
    }
}