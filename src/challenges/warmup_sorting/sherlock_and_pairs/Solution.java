package challenges.warmup_sorting.sherlock_and_pairs;

/**
 * Created by Eric on 15-3-14.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i< T; i++){
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; j++){
                a[j] = sc.nextInt();
            }
            Arrays.sort(a);
            System.out.println(permutations(a));
        }
    }
    public static long permutations(int[] a){
        int len = a.length;
        long count = 0;
        long repeat = 0;
        for(int i = 1; i< len; i++){
            if(a[i] == a[i-1]){
                repeat++;
            }else{
                if(repeat != 0){
                    count += repeat * (repeat+1);
                }
                repeat = 0;
            }
        }
        if(repeat != 0){
            count += repeat * (repeat+1);
        }
        return count;
    }
}