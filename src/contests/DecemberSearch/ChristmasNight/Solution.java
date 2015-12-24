import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        while(sc.hasNext()){
            solve(sc, pw);
        }
        sc.close();
        pw.flush();
        pw.close();
    }

    private static void solve(Scanner sc, PrintWriter pw){
        int T = sc.nextInt();
        for(int j = 0; j < T; j++){
            int N = sc.nextInt();
            int M = sc.nextInt();
            HashSet[] g = new HashSet[N];
            for(int i = 0; i < N; i++){
                g[i] = new HashSet<Integer>();
            }
            for(int i = 0; i < M; i++){
                int a = sc.nextInt() - 1;
                int b = sc.nextInt() - 1;
                g[a].add(b);
                g[b].add(a);
            }
            int[] a = new int[N];
            for(int i = 0; i < N; i++){
                a[i] = sc.nextInt();
            }
            solve(a, g, N, pw);
        }
    }

    private static void solve(int[] a, HashSet<Integer>[] g, int N, PrintWriter pw){
        long ans = 0;
        boolean[] visited = new boolean[N];
        for(int i = 0; i < N; i++){
            if(!visited[i]){
                long cnt = a[i];
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int cur = q.poll();
                    for(int neighbor : g[cur]){
                        if(!visited[neighbor]){
                            visited[neighbor] = true;
                            cnt += a[neighbor];
                            q.add(neighbor);
                        }
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        pw.println(ans);
    }
}