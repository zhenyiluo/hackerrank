package challenges.warmup_sorting.cut_the_sticks;

/**
 * Created by Zhenyi Luo on 15-3-9.
 */
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int prev = -1;
        int count = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < N; i++){
            if(arr[i] != prev){
                if(count != 0){
                    list.add(count);
                }
                count = 1;
            }else{
                count ++;
            }
            prev = arr[i];
        }
        if(count != 0){
            list.add(count);
        }
        int index = 0;
        while(N > 0){
            System.out.println(N);
            N -= list.get(index++);
        }
    }
}