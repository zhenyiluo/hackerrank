package challenges.strings.reverse_shuffle_merge;

/**
 * Created by Eric on 15-3-15.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        System.out.println(getSmallest(sb.toString()));
    }
    public static String getSmallest(String s){
        int[] count = new int[26];
        int len = s.length();
        for(int i = 0; i< len; i++){
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        for(int i = 0; i < 26; i++){
            count[i] /= 2;
        }
        int mask = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                mask |= 1 << i;
            }
        }
        return dfs(s, count, 0, mask);
    }
    public static String dfs(String s, int[] count, int startS, int mask){
        if(Integer.bitCount(mask) == 0){
            return "";
        }
        StringBuilder result = new StringBuilder("");
        int tmp = mask;
        boolean flag = true;
        while(tmp != 0 && flag){
            int rightMost = Integer.numberOfTrailingZeros(tmp);
            count[rightMost] --;
            char c = (char) ('a' + rightMost);
            int index = s.indexOf(c, startS);
            if(isOkay(s, index+1, count)){
                if(count[rightMost] == 0){
                    mask ^= 1 << rightMost;
                }
                result.append(c);
                result.append(dfs(s, count, index+1, mask));

                flag = false;
            }else{
                count[rightMost] ++;
                tmp ^= 1 << rightMost;
            }
        }

        return result.toString();
    }
    public static boolean isOkay(String s, int index , int[] count){
        int mask = 0;
        for(int i = 0; i < 26; i++){
            if(count[i] != 0){
                mask |= 1 << i;
            }
        }
        int[] tmp = Arrays.copyOfRange(count, 0, count.length);
        while(index < s.length() && mask != 0){
            int n = s.charAt(index) -'a';
            tmp[n]--;
            if(tmp[n] == 0){
                mask ^= 1 << n;
            }
            index ++;
        }
        if(mask == 0){
            return true;
        }else{
            return false;
        }
    }
}