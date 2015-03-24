package challenges.greedy.priyankaAndToys;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-24.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(n, a));
    }
    public static int solve(int n, int[] a){
        int count = 0;
        Arrays.sort(a);
        int index = 0;
        while(index < n){
            count++;
            int cur = a[index];
            index = Arrays.binarySearch(a, cur+5);
            if(index < 0){
                index = -index - 1;
            }
        }
        return count;
    }
}
