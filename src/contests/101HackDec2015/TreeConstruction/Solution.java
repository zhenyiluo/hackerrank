import java.io.PrintWriter;
import java.util.Scanner;

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
        int[] parent = new int[n];
        int totalEdges = 0;
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            totalEdges += a[i];
        }
        int totalNodes = n;
        int cur = findMin(a);
        helper(cur, totalNodes, a, totalEdges, n, parent);

        for(int i= 0; i < n; i++){
            pw.println(parent[i]);
        }

    }

    private static int findMin(int[] a){
        int ret = Integer.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            if(a[i] != 0 && a[i] < min){
                min = a[i];
                ret = i;
            }
        }
        return ret;
    }

    static void helper(int cur, int totalNodes, int[] a, int totalEdges, int n, int[] parent){
        while(totalNodes != 0){



            for(int i = 0; i < n; i++){
                if(i == cur || a[i] == 0){
                    continue;
                }

                a[cur] --;
                a[i] --;
                if(a[cur] == 0){
                    totalNodes --;
                }

                if(a[i] == 0){
                    totalNodes --;
                }

                totalEdges -= 2;
                if(totalNodes == 0 || (totalNodes -1) * 2 == totalEdges){
                    parent[cur] = i+1;
                    cur = findMin(a);
                    break;
                }else{
                    if(a[cur] == 0){
                        totalNodes ++;
                    }
                    if(a[i] == 0){
                        totalNodes ++;
                    }
                    totalEdges +=2;
                    a[cur] ++;
                    a[i] ++;

                }
            }
        }
    }
}