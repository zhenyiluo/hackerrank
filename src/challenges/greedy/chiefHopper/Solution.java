package challenges.greedy.chiefHopper;

/**
 * Created by Zhenyi Luo on 15-3-26.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        System.out.println(solve(n, a));
    }
    public static int solve(int n, int[] a){
        int result = 0;
        int high = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            high = Math.max(high, a[i]);
        }
        int PermHigh = high;
        int low = 1;
        while(low <= high){
            int mid = (low+high)/2;
            if(isOkay(mid, n, a, PermHigh)){
                result = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return result;
    }
    public static boolean isOkay(int num, int n, int[] a, int high){
        int cur = num;
        for(int i = 0; i < n; i++){
            if(a[i] >= cur){
                cur -= a[i]-cur;
                if(cur < 0){
                    return false;
                }
            }else{
                cur += cur - a[i];
            }

            if(cur >= high){
                return true;
            }
        }
        return true;
    }
}