package challenges.search_combinatorics.equations;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-3-22.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solve(n));
    }
    public static long solve(int n){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        ArrayList<Long> primesExponent = new ArrayList<Long>();
        long result = 1;
        primes.add(2);
        for(int i = 3; i <= n; i++ ){
            if(isPrime(i, primes)){
                primes.add(i);
            }
        }
        for(int p : primes){
            long count = 0;
            long divisor = p;
            while(n / divisor > 0){
                count += n / divisor;
                divisor *= p;
            }
            primesExponent.add(count);
        }

        for(long e : primesExponent){
            result *= (e*2+1) % 1000007;
            result = result % 1000007;
        }
        return result;
    }
    public static boolean isPrime(int n, ArrayList<Integer> primes){
        for(int p : primes){
            if(n % p == 0){
                return false;
            }
            if(p * p > n){
                return true;
            }
        }
        return true;
    }
}
