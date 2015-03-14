package challenges.warmup_sorting.acm_icpc_team;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;
import java.math.BigInteger;
public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        BigInteger[] arr = new BigInteger[N];
        for(int i = 0; i < N; i++){
            String s= sc.next();
            arr[i] = new BigInteger(s, 2);
        }
        Result result = solve(arr);
        System.out.println(result.first);
        System.out.println(result.second);
    }
    public static Result solve(BigInteger[] arr){
        int first = 0;
        int second = 0;
        int len = arr.length;
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                BigInteger tmp = arr[i].or(arr[j]);
                first = Math.max(first, tmp.bitCount());
            }
        }
        for(int i = 0; i < len-1; i++){
            for(int j = i+1; j < len; j++){
                BigInteger tmp = arr[i].or(arr[j]);
                if(tmp.bitCount() == first){
                    second++;
                }
            }
        }
        return new Result(first, second);
    }
}

class Result{
    int first;
    int second;
    public Result(int first, int second){
        this.first = first;
        this.second = second;
    }
}