package challenges.strings.gem_stones;

/**
 * Created by Eric on 15-3-14.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];

        for(int i = 0; i < n; i++){
            s[i] = sc.next();
        }
        System.out.println(getGems(s));
    }
    public static int getGems(String[] s){
        int len = s.length;
        int[] mask = new int[len];
        for(int i = 0; i < len; i++){
            for(int j = 0; j < s[i].length(); j++){
                mask[i] |= 1 << (s[i].charAt(j) - 'a');
            }
        }
        for(int i = 1; i < len; i++){
            mask[0] &= mask[i];
        }

        return Integer.bitCount(mask[0]);
    }
}