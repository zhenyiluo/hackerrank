package challenges.warmup_sorting.maxsubarray;

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
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int j = 0; j < size; j++){
                arr[j] = sc.nextInt();
            }
            boolean flag = checkAllMinus(arr);
            int con;
            int nCon;
            if(flag){
                con = findMinimal(arr);
                nCon = con;
            }else{
                con = findContinuous(arr);
                nCon = findNonContinuous(arr);
            }
            System.out.println(con + " " + nCon);
        }
    }
    public static int findMinimal(int[] arr){
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > result){
                result = arr[i];
            }
        }
        return result;
    }
    public static boolean checkAllMinus(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                return false;
            }
        }
        return true;
    }
    public static int findContinuous(int[] arr){
        int result = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(sum >= 0){
                result = Math.max(result, sum);
            }else{
                sum = 0;
            }
        }
        return result;
    }
    public static int findNonContinuous(int[] arr){
        int result = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0){
                result += arr[i];
            }
        }
        return result;
    }
}