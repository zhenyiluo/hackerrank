package challenges.search_combinatorics.encryption;

/**
 * Created by Zhenyi Luo on 15-3-21.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(solve(s));
    }
    public static String solve(String s){
        StringBuilder result = new StringBuilder("");
        int len = s.length();
        int low = (int) Math.sqrt(len);
        int high = (low * low == len)? low : low+1;
        int row = 0;
        int col = 0;
        boolean flag = true;
        for(int i = low; i <= high && flag; i++){
            for(int j = i; j <= high && flag; j++){
                if(i*j >=len){
                    row = i;
                    col = j;
                    flag = false;
                }
            }
        }
        for(int j = 0; j < col; j++){
            for(int i = 0; i< row; i++){
                if(i*col + j < len){
                    result.append(s.charAt(i* col + j));
                }
            }
            result.append(" ");
        }
        return result.toString();
    }
}