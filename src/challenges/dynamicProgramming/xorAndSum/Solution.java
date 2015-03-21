package challenges.dynamicProgramming.xorAndSum;

/**
 * Created by Zhenyi Luo on 15-3-18.
 */
import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println(solve(a, b));
    }
    public static int solve(String aa, String bb){
        BigInteger a = new BigInteger(aa);
        BigInteger b = new BigInteger(bb);
        BigInteger modValue = BigInteger.valueOf(1000000007);
        BigInteger result = BigInteger.valueOf(0);
        for(int i = 0; i <= 314159; i++){
            result = result.add(a.xor(b.shiftLeft(i)));
        }
        result = result.mod(modValue);
        return result.intValue();
    }
}
