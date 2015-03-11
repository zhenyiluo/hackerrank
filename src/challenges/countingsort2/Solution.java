package challenges.countingsort2;

/**
 * Created by Eric on 15-3-11.
 */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[100];
        for(int i = 0; i < N; i++){
            int index = sc.nextInt();
            a[index]++;
        }
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < a[i]; j++){
                System.out.print(i + " ");
            }
        }
    }
}