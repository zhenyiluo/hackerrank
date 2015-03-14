package challenges.warmup_sorting.is_fibo;

/**
 * Created by Eric on 15-3-10.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            double n = sc.nextDouble();
            if(isFibo(n)){
                System.out.println("IsFibo");
            }else{
                System.out.println("IsNotFibo");
            }
        }
    }

    public static boolean isFibo(double n){
        return isPerfectSquare(5 * n * n +4) || isPerfectSquare(5 * n * n -4);
    }

    public static boolean isPerfectSquare(double N){
        return Math.sqrt(N) % 1 <= 0.000001;
    }
}