package challenges.strings.make_it_anagram;

/**
 * Created by Eric on 15-3-14.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int[] a = new int[26];
        String s1 = sc.next();
        String s2 = sc.next();
        for(int i = 0; i < s1.length(); i++){
            int index = s1.charAt(i) - 'a';
            a[index] ++;
        }
        for(int i = 0; i < s2.length(); i++){
            int index = s2.charAt(i) - 'a';
            a[index] --;
        }
        int result = 0;
        for(int i = 0; i < 26; i++){
            result += Math.abs(a[i]);
        }
        System.out.println(result);
    }
}