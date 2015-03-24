package challenges.search_combinatorics.buildingAList;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            String s = sc.next();
            System.out.println(solve(n, s));
        }
    }
    public static String solve(int n, String s){
        ArrayList<String> list = new ArrayList<String>();
        list.add("");
        for(int i = 0; i< n; i++){
            char c = s.charAt(i);
            int size = list.size();
            for(int j = 0; j < size; j++){
                list.add(list.get(j) + c);
            }
        }
        Collections.sort(list);
        StringBuilder sb = new StringBuilder("");
        for(String tmp : list){
            if(!tmp.equals("")){
                sb.append(tmp + "\n");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}