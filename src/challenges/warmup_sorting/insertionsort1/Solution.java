package challenges.warmup_sorting.insertionsort1;

/**
 * Created by Eric on 15-3-8.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = sc.nextInt();
        }

        int v = arr[size-1];
        int i ;
        for(i = size -2; i >= 0; i--){
            if(arr[i] > v){
                arr[i+1] = arr[i];
                print(arr);
            }else{

                break;
            }
        }
        arr[i+1] = v;
        print(arr);
    }
    public static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}