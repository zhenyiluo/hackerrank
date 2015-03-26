package challenges.greedy.MiniMax;

/**
 * Created by Zhenyi Luo on 15-3-26.
 */

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
        int p = sc.nextInt();
        int q = sc.nextInt();
        System.out.println(solve(p, q, n, a));
    }
    public static int solve(int p, int q, int n, int[] a){
        int max = Integer.MIN_VALUE;
        int result = 0;
        TreeSet<Integer> ts = new TreeSet<Integer>();
        for(int i= 0; i < n; i++){
            ts.add(a[i]);
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(p);
        Arrays.sort(a);
        for(int i = 0; i < n-1; i++){
            int dif = a[i+1] - a[i];
            if(dif % 2 == 0){
                int num = (a[i+1]+a[i])/2;
                if(num >= p && num <= q){
                    queue.add(num);
                }
            }else{
                int num1 = (a[i+1]+a[i])/2;
                int num2 = (a[i+1]+a[i])/2 + 1;
                if(num1 >=p && num1 <= q){
                    queue.add(num1);
                }
                if(num2 >=p && num2 <=q){
                    queue.add(num2);
                }
            }
        }
        queue.add(q);
        for(int i : queue){
            int min = Integer.MAX_VALUE;
            Integer low = ts.ceiling(i);
            Integer high = ts.floor(i);
            if(low != null){
                min = Math.min(min, Math.abs(low - i));
            }
            if(high != null){
                min = Math.min(min, Math.abs(high - i));
            }
            if(min > max){
                result = i;
                max = min;
            }
        }
        return result;
    }
}