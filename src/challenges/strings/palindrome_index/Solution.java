package challenges.strings.palindrome_index;

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
            String s= sc.next();
            System.out.println(getIndex(s));
        }
    }
    public static int getIndex(String s){
        if(isPalindrome(s)){
            return -1;
        }
        int result = -2;
        int len = s.length();
        for(int i = 0; i< len/2; i++){
            if(s.charAt(i) != s.charAt(s.length() -i -1)){
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if(isPalindrome(sb.toString())){
                    result = i;
                }
                sb = new StringBuilder(s);
                sb.deleteCharAt(s.length()-i-1);
                if(isPalindrome(sb.toString())){
                    result = s.length()-i-1;
                }
                break;
            }
        }
        return result;
    }
    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len/2; i++){
            if(s.charAt(i) != s.charAt(s.length() -i -1)){
                return false;
            }
        }
        return true;
    }
}