package challenges.search_combinatorics.strangeGrid;

import java.util.Scanner;

/**
 * Created by Zhenyi Luo on 15-4-2.
 */
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long r = sc.nextInt();
        int c = sc.nextInt();
        solve(r, c);
    }

    public static void solve(long r, int c){
        int len = 1;
        while(calculate(len) < r){
            len++;
        }
        StringBuilder sb = new StringBuilder("");
        while(len > 1){
            long divide = calculate(len - 1);
            long num;
            num = (r-1) / divide;
            sb.append(num);
            r -= divide * num;
            len--;
        }
        int lastDigit;
        if(r == 1){
            lastDigit = 0;
        }else{
            lastDigit = 1;
        }
        for(int i = 0; i < c-1; i++){
            lastDigit += 2;
        }
        sb.append(lastDigit);
        System.out.println(sb.toString().trim());
    }

    public static long calculate(int len){
        return 2 * (long)Math.pow(10, len-1);
    }
}
