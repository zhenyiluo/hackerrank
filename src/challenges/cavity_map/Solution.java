package challenges.cavity_map;

/**
 * Created by Eric on 15-3-9.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n];
        StringBuilder[] result = new StringBuilder[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.next();
            result[i] = new StringBuilder(s[i]);
        }
        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < n-1; j++) {
                if(s[i].charAt(j) > s[i].charAt(j-1) && s[i].charAt(j) > s[i].charAt(j+1) && s[i].charAt(j) >
                        s[i-1].charAt(j) && s[i].charAt(j) > s[i+1].charAt(j)){
                    result[i].setCharAt(j, 'X');
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(result[i].toString());
        }
    }
}