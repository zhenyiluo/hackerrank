package challenges.strings.bigger_is_greater;

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
            System.out.println(getBigger(s));
        }
    }
    public static String getBigger(String s){

        char[] a = s.toCharArray();
        int len = s.length();
        if(len == 1){
            return "no answer";
        }
        int index = -1;
        for(int i = len-1; i>= 1; i--){
            if(a[i] > a[i-1]){
                index = i-1;
                break;
            }
        }
        if(index == -1){
            return "no answer";
        }
        int indexL = -1;
        for(int i = index +1; i < len; i++){
            if(a[i] > a[index]){
                indexL = i;
            }
        }
        swap(a, index, indexL);
        reverse(a, index+1, len-1);
        return new String(a);
    }
    public static void swap(char[] a, int i, int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    public static void reverse(char[] a, int i, int j){
        int len = j-i+1;
        for(int k = 0; k < len/2; k++){
            swap(a, i+k, j-k);
        }
    }
}