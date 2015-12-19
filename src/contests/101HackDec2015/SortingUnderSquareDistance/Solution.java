import java.io.PrintWriter;
import java.util.Scanner;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        PrintWriter pw = new PrintWriter(System.out);
        Scanner sc = new Scanner(System.in);
        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }

    private static void solve(Scanner sc, PrintWriter pw){
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        List<Integer> list = countLarger(a);
        long ret = 0;
        for(int num : list){
            ret += num;
        }
        pw.println(ret);
    }

    public static List<Integer> countLarger(int[] nums) {
        List<Integer> ret = new LinkedList<>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        int len = nums.length;
        ArrayList<Integer> sorted = new ArrayList<>();
        for(int i = 0; i <  len; i++){
            if(i == 0){
                ret.add(0);
                sorted.add(nums[i]);
                continue;
            }
            int index = helper(sorted, nums[i]);
            sorted.add(index+1, nums[i]);
            ret.add(sorted.size() - index-2);
        }
        return ret;
    }

    private static int helper(ArrayList<Integer> sorted, int num){
        int low = 0;
        int high = sorted.size() - 1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(sorted.get(mid) > num){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return high;
    }
}