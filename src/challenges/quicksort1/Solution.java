package challenges.quicksort1;

/**
 * Created by Eric on 15-3-10.
 */
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        solve(a);
    }
    public static void solve(int[] a ){
        ArrayList<Integer> listS = new ArrayList<Integer>();
        ArrayList<Integer> listL = new ArrayList<Integer>();
        int tmp = a[0];
        for(int i = 0; i < a.length; i++){
            if(a[i] < tmp){
                listS.add(a[i]);
            }else{
                listL.add(a[i]);
            }
        }
        for(int n : listS){
            System.out.print(n + " ");
        }
        for(int n : listL){
            System.out.print(n + " ");
        }
    }
}