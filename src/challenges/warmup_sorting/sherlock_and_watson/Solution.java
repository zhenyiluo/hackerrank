package challenges.warmup_sorting.sherlock_and_watson;

/**
 * Created by Zhenyi Luo on 15-3-12.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        int tmp = k % n;
        for(int i = 0; i < tmp; i++){
            list.add(0, list.remove(list.size()-1));
        }
        StringBuilder sb = new StringBuilder("");
        int[] queries = new int[q];
        for(int i = 0; i < q; i++){
            queries[i] = sc.nextInt();
        }
        for(int i = 0; i < q; i++){
            sb.append(list.get(queries[i]) + "\n");
        }
        System.out.println(sb.toString());
    }
}