package challenges.regex.sayingHi;

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
            String s1 = s.toLowerCase();
            if(s1.startsWith("hi ") && !s1.startsWith("hi d")){
                System.out.println(s);
            }
        }
    }
}