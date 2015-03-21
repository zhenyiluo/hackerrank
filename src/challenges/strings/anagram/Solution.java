package challenges.strings.anagram;

/**
 * Created by Zhenyi Luo on 15-3-14.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            String s = sc.next();
            System.out.println(getNum(s));
        }
    }
    public static int getNum(String s){
        if(s.length() % 2 != 0){
            return -1;
        }
        int[] a = new int[26];
        for(int i = 0; i < s.length()/2; i++){
            int index = s.charAt(i) - 'a';
            a[index] ++;
        }
        for(int i = s.length()/2; i < s.length(); i++){
            int index = s.charAt(i) - 'a';
            a[index] --;
        }
        int count = 0;
        for(int i = 0; i < 26; i++){
            count += Math.abs(a[i]);
        }
        return count/2;
    }
}