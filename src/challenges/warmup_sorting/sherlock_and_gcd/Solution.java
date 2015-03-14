package challenges.warmup_sorting.sherlock_and_gcd;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int j = 0; j < N; j++){
                arr[j] = sc.nextInt();
            }
            System.out.println(solve(arr));
        }
    }
    public static String solve(int[] arr){
        if(hasOne(arr)){
            return "YES";
        }else{
            for(int i = 0; i < arr.length-1; i++){
                for(int j = i+1; j < arr.length; j++){
                    if(gcd(arr[i], arr[j])== 1){
                        return "YES";
                    }
                }
            }
            return "NO";
        }
    }
    public static int gcd(int a, int b){
        if(b == 0){
            return a;
        }else{
            return gcd(b, a % b);
        }
    }
    public static boolean hasOne(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 1){
                return true;
            }
        }
        return false;
    }
}