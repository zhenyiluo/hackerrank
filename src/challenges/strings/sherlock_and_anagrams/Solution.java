package challenges.strings.sherlock_and_anagrams;

/**
 * Created by Zhenyi Luo on 15-3-15.
 */

import java.util.Arrays;
import java.util.HashMap;
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
        int result = 0;
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        int len = s.length();
        for(int i = 0; i < len; i++){
            for(int l = 1; i+l <= len; l++){
                String tmp = s.substring(i, i + l);
                char[] c = tmp.toCharArray();
                Arrays.sort(c);
                String t = new String(c);
                if(hm.containsKey(t)){
                    hm.put(t, hm.get(t) + 1);
                }else{
                    hm.put(t, 1);
                }
            }
        }
        for(String key: hm.keySet()){
            int num = hm.get(key);
            if(num >=2){
                result += (num * (num-1))/2;
            }
        }
        return result;
    }
}