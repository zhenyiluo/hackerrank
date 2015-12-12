import java.io.PrintWriter;
import java.util.*;
public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);


        solve(sc, pw);
        sc.close();
        pw.flush();
        pw.close();
    }
    static int[] tree;
    static int[] pos;
    static int N;
    private static void solve(Scanner sc, PrintWriter pw){
        int M = sc.nextInt();
        N = sc.nextInt();
        int Q = sc.nextInt();
        tree = new int[N+1];
        pos = new int[N];
        int[] scene = new int[M];

        for(int i = 0; i < N; i++){
            pos[i] = sc.nextInt();
            scene[pos[i]]++;
        }

        for(int i = 0; i < M; i++){
            update(scene[i]+1, 1);
        }

        for(int i = 0; i < Q; i++){
            int a = sc.nextInt();
            if(a == 2){
                int p = sc.nextInt();
                pw.println(query(p));
            }else{
                int ni = sc.nextInt();
                int mi = sc.nextInt();
                if(pos[ni] == mi){
                    continue;
                }

                update(scene[pos[ni]] +1 , -1);
                scene[pos[ni]]--;
                update(scene[pos[ni]] +1 , 1);
                pos[ni] = mi;
                update(scene[pos[ni]] +1, -1);
                scene[pos[ni]]++;
                update(scene[pos[ni]] +1 , 1);
            }
        }

    }

    private static void update(int pos, int val){
        for(int i = pos; i <= N; i += i & (-i)){
            tree[i] += val;
        }
    }

    private static int query(int pos){
        int ret = 0;
        for(int i = pos; i >0; i -= i & (-i)){
            ret += tree[i];
        }
        return ret;
    }
}