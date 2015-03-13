package countingsort3;

/**
 * Created by Eric on 15-3-12.
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[100];
        sc.nextLine();
        for(int i = 0; i < n; i++){
            int index = Integer.valueOf(sc.nextLine().split("\\s+")[0]);
            a[index] ++;
        }
        for(int i = 1; i < 100; i++){
            a[i] +=  a[i-1];
        }
        for(int i = 0; i < 100; i++){
            System.out.print(a[i] + " ");
        }
    }
}