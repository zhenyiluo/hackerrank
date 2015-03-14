package challenges.warmup_sorting.insertionsort2;

/**
 * Created by Eric on 15-3-10.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] arr = new int[s];
        StringBuilder[] sb = new StringBuilder[s-1];
        for(int i = 0; i < s; i++){
            arr[i] = sc.nextInt();
        }

        for(int i = 1; i < s; i++){
            int tmp = arr[i];
            int j;
            for(j = i -1; j >=0; j--){
                if(arr[j] > tmp){
                    arr[j+1] = arr[j];
                }else{
                    break;
                }
            }
            arr[j+1] = tmp;
            sb[i-1] = new StringBuilder("");
            for(int k = 0; k < s; k++){
                sb[i-1].append(arr[k] + " ");
            }
        }
        for(int i = 0; i < s-1; i++){
            System.out.println(sb[i].toString());
        }
    }
}