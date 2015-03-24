package challenges.search_combinatorics.pickingCards;

/**
 * Created by Zhenyi Luo on 15-3-23.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i = 0; i < T; i++){
            int n = sc.nextInt();
            int[] c = new int[n];
            for(int j = 0; j < n; j++){
                c[j] = sc.nextInt();
            }
            System.out.println(solve(n, c));
        }
    }
    public static long solve(int n, int[] c){
        long result = 1;
        Arrays.sort(c);
        int prev = -1;
        TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();
        for(int i = 0; i < n; i++){
            if(c[i] != prev){
                if(i != 0){
                    tm.put(prev, i-1);
                }
                prev = c[i];
            }
        }
        tm.put(prev, n-1);
        for(int i = 0; i< n; i++){
            int num = tm.get(tm.floorKey(i)) - i + 1;
            if(num <= 0){
                return 0;
            }else{
                result *= num;
                result = result % 1000000007;
            }
        }
        return result;
    }
}