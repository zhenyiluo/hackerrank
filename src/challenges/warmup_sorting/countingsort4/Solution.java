package challenges.warmup_sorting.countingsort4;

/**
 * Created by Eric on 15-3-12.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            s[i] = sc.next();
        }
        ArrayList<LinkedList<String>> lists = sort(a, s);
        StringBuilder sb = new StringBuilder("");
        for(LinkedList<String> list: lists){
            for(String tmp: list){
                sb.append(tmp + " ");
            }
        }
        System.out.println(sb.toString());
    }
    public static ArrayList<LinkedList<String>> sort(int[] a, String[] s){
        int size = a.length;
        ArrayList<LinkedList<String>> result = new ArrayList<LinkedList<String>>();
        for(int i = 0; i < 100; i++){
            result.add(new LinkedList<String>());
        }
        for(int i = 0; i < size/2; i++){
            result.get(a[i]).add("-");
        }
        for(int i = size/2; i < size; i++){
            result.get(a[i]).add(s[i]);
        }
        return result;
    }
}