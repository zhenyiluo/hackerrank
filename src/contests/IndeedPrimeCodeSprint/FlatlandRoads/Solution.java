import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int p = sc.nextInt();
        HashMap<Integer, HashSet<Integer>> g = new HashMap<>();
        for(int i = 0; i < e; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(!g.containsKey(a)){
                g.put(a, new HashSet<>());
            }
            g.get(a).add(b);

            if(!g.containsKey(b)){
                g.put(b, new HashSet<>());
            }
            g.get(b).add(a);
        }
        solve(g, p, n);
    }

    private static void solve(HashMap<Integer, HashSet<Integer>> g, int p, int N){
        HashMap<Integer, HashSet<Integer>> tmp = new HashMap<>(g);

        while(true){
            boolean flag = false;
            Iterator<Integer> it = g.keySet().iterator();
            while(it.hasNext()){
                int n = it.next();
                if(g.get(n).size() == 1){
                    flag = true;
                    int b = g.get(n).iterator().next();
                    g.get(b).remove(n);
                    it.remove();
                }
            }
            if(!flag){
                break;
            }
        }

        HashMap<Integer, Integer> mapping = new HashMap<>();
        int mark = 0;
        for(int n : g.keySet()){
            if(mapping.containsKey(n)){
                continue;
            }
            dfs(n, g, mark, mapping);
            mark++;
        }

        for(int n : tmp.keySet()){
            if(mapping.containsKey(n)){
                continue;
            }
            mapping.put(n, mark);
            mark++;
        }

        HashMap<Integer, Integer> colorCount = new HashMap<>();
        for(int n : mapping.keySet()){
            int color = mapping.get(n);
            if(colorCount.containsKey(color)){
                colorCount.put(color, colorCount.get(color) + 1);
            }else{
                colorCount.put(color, 1);
            }
        }

        HashMap<Integer, HashSet<Integer>> colorMap = new HashMap<>();
        for(int n : tmp.keySet()){
            for(int neighbor : tmp.get(n)){
                int color1 = mapping.get(n);
                int color2 = mapping.get(neighbor);
                if(color1 != color2){
                    if(!colorMap.containsKey(color1)){
                       colorMap.put(color1, new HashSet<>());
                    }
                    colorMap.get(color1).add(color2);
                    if(!colorMap.containsKey(color2)){
                        colorMap.put(color2, new HashSet<>());
                    }
                    colorMap.get(color2).add(color1);
                }
            }
        }

        HashMap<Integer, Integer> ret = new HashMap<>();
        for(int n : colorMap.keySet()){
            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> visited = new HashSet<>();
            q.add(n);
            q.add(0);
            visited.add(n);
            while(!q.isEmpty()){
                int color = q.poll();
                int step = q.poll();
                if(step > p){
                    break;
                }
                sum += colorCount.get(color);
                for(int neighbor : colorMap.get(color)){
                    if(!visited.contains(neighbor)){
                        visited.add(neighbor);
                        q.add(neighbor);
                        q.add(step + 1);
                    }
                }
            }
            sum --;
            ret.put(n, sum);
        }
        PrintWriter pw = new PrintWriter(System.out);
        for(int i =1; i <= N; i++){
            pw.println(ret.get(mapping.get(i)));
        }
        pw.flush();
        pw.close();
    }

    private static void dfs(int n, HashMap<Integer, HashSet<Integer>> g, int mark, HashMap<Integer, Integer> mapping) {
        if(mapping.containsKey(n)){
            return;
        }
        mapping.put(n, mark);
        for(int neighbor : g.get(n)){
            dfs(neighbor, g, mark, mapping);
        }
    }
}