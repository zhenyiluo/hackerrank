
/**
 * Created by eric on 2015-12-12.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Solution1 {

    public static class Pair {
        int v, w;

        public Pair(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }

    static int N, M, K;
    static int[] arr;
    static int[][] mat;
    static int[] components, componentsSize;
    static int[] componentsResult;
    static String str;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        N = s.nextInt();
        M = s.nextInt();
        K = s.nextInt();
        iGraph g = new iGraph(N);
        for (int i = 0; i < M; i++) {
            int u = s.nextInt() - 1;
            int v = s.nextInt() - 1;
            g.addEdge(u, v);
            g.addEdge(v, u);
        }
        List<List<Integer>> bc = g.biconnectedComponents();
        components = new int[N];
        componentsSize = new int[bc.size()];
        componentsResult = new int[bc.size()];
        
        int component = 0;
        for (List<Integer> l : bc) {
            componentsSize[component] = l.size();
            for (Integer ii : l) {
                components[ii] = component;
            }
            component++;
        }
        
        iGraph componentTree = new iGraph(component);
        for (Pair p : g.bridges()) {
            int uCom = components[p.v];
            int vCom = components[p.w];
            componentTree.addEdge(uCom, vCom);
            componentTree.addEdge(vCom, uCom);
        }
        
        if (K < component - 1) {
            componentTree.loadMem(component, K + 1);
            for (int i = 0; i < component; i++) {
                componentsResult[i] = componentTree.dp(i, K);
            }

            for (int i = 0; i < N; i++) {
                output.append(componentsResult[components[i]] - 1 + "\n");
            }
        } else {
            for (int i = 0; i < N; i++) {
                output.append(N - 1 + "\n");
            }
        }

        System.out.print(output);
    }

    static public class iGraph {

        public void loadMem(int n, int m) {
            mem = new Integer[n][m];
        }

        Integer[][] mem;

        public int dp(int curr, int steps) {
            //		System.out.println(curr+" "+steps);
            if (steps == 0) {
//				System.out.println(" "+curr+" "+steps+" "+componentsSize[curr]);
                return componentsSize[curr];
            }
            if (mem[curr][steps] == null) {
                int ans;
                if (steps == 1) {
                    ans=componentsSize[curr];
                    for (int i : graph[curr]) {
                        ans += dp(i, steps - 1);
                    }
                } else {
                    ans=dp(curr, steps-2);
                    for (int i : graph[curr]) {
                        ans += dp(i, steps - 1) - dp(curr, steps - 2);
                    }
                }
                mem[curr][steps] = ans;
            }
//			System.out.println(" "+curr+" "+steps+" "+mem[curr][steps]);
            return mem[curr][steps];
        }

        public void dfs(int size, int or, int curr, int steps) {
            if (steps < 0)
                return;
            componentsResult[curr] += size;
            for (int i : graph[curr]) {
                if (i != or) {
                    dfs(size, curr, i, steps - 1);
                }
            }
        }

        List<Edge>[] edges;
        List<Integer>[] graph;
        BiconnectedComponents bc;

        public iGraph(int size) {
            edges = new List[size];
            graph = new List[size];
            for (int i = 0; i < size; i++) {
                edges[i] = new LinkedList<Edge>();
                graph[i] = new LinkedList<Integer>();
            }
            bc = new BiconnectedComponents();
        }

        public void addEdge(int v, int w) {
            graph[v].add(w);
        }

        public void addEfficientEdge(int v, int w, long weight) {
            edges[v].add(new Edge(w, weight));
        }

        public void addEdge(int v, int w, long weight) {
            graph[v].add(w);
            edges[v].add(new Edge(w, weight));
        }

        public List<List<Integer>> biconnectedComponents() {
            if (bc.components == null)
                bc.biconnectedComponents(graph);
            return bc.components;
        }

        public List<Integer> cutPoints() {
            if (bc.cutPoints == null)
                bc.biconnectedComponents(graph);
            return bc.cutPoints;
        }

        public List<Pair> bridges() {
            if (bc.bridges == null)
                bc.biconnectedComponents(graph);
            return bc.bridges;
        }

        private static class Edge {
            int v;
            long cost;

            public Edge(int node, long weight) {
                this.v = node;
                this.cost = weight;
            }
        }

        private void dfs(List<Integer>[] graph, boolean[] used,
                         List<Integer> res, int u) {
            used[u] = true;
            for (int v : graph[u])
                if (!used[v])
                    dfs(graph, used, res, v);
            res.add(u);
        }

		/* ---------------------------------------------- */

        public List<List<Integer>> stronglyConnectedComponents() {
            int n = graph.length;
            boolean[] used = new boolean[n];
            List<Integer> order = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (!used[i])
                    dfs(graph, used, order, i);

            List<Integer>[] reverseGraph = new List[n];
            for (int i = 0; i < n; i++)
                reverseGraph[i] = new ArrayList<>();
            for (int i = 0; i < n; i++)
                for (int j : graph[i])
                    reverseGraph[j].add(i);

            List<List<Integer>> components = new ArrayList<>();
            Arrays.fill(used, false);
            Collections.reverse(order);

            for (int u : order)
                if (!used[u]) {
                    List<Integer> component = new ArrayList<>();
                    dfs(reverseGraph, used, component, u);
                    components.add(component);
                }

            return components;
        }

		/* ---------------------------------------------- */

        /* No checkea que sea valido */
        public List<Integer> eulerCycleUndirected(int u) {
            Set<Long> usedEdges = new HashSet<>();
            int n = graph.length;
            int[] curEdge = new int[n];
            List<Integer> res = new ArrayList<>();
            dfs(graph, curEdge, usedEdges, res, u);
            Collections.reverse(res);
            return res;
        }

        private void dfs(List<Integer>[] graph, int[] curEdge,
                         Set<Long> usedEdges, List<Integer> res, int u) {
            while (curEdge[u] < graph[u].size()) {
                int v = graph[u].get(curEdge[u]++);
                if (usedEdges.add(((long) Math.min(u, v) << 32)
                        + Math.max(u, v)))
                    dfs(graph, curEdge, usedEdges, res, v);
            }
            res.add(u);
        }

        public List<Integer> eulerCycleDirected(int u) {
            int n = graph.length;
            int[] curEdge = new int[n];
            List<Integer> res = new ArrayList<>();
            dfs(graph, curEdge, res, u);
            Collections.reverse(res);
            return res;
        }

        private void dfs(List<Integer>[] graph, int[] curEdge,
                         List<Integer> res, int u) {
            while (curEdge[u] < graph[u].size()) {
                dfs(graph, curEdge, res, graph[u].get(curEdge[u]++));
            }
            res.add(u);
        }

		/* ---------------------------------------------- */

        private static class BiconnectedComponents {

            List<Integer>[] graph;
            boolean[] visited;
            Stack<Integer> stack;
            int time;
            int[] tin;
            int[] lowlink;
            List<List<Integer>> components;
            List<Integer> cutPoints;
            List<Pair> bridges;

            public List<List<Integer>> biconnectedComponents(
                    List<Integer>[] graph) {
                int n = graph.length;
                this.graph = graph;
                visited = new boolean[n];
                stack = new Stack<>();
                time = 0;
                tin = new int[n];
                lowlink = new int[n];
                components = new ArrayList<>();
                cutPoints = new ArrayList<>();
                bridges = new ArrayList<>();

                for (int u = 0; u < n; u++)
                    if (!visited[u])
                        dfs(u, -1);

                return components;
            }

            void dfs(int u, int p) {
                visited[u] = true;
                lowlink[u] = tin[u] = time++;
                stack.add(u);
                int children = 0;
                boolean cutPoint = false;
                for (int v : graph[u]) {
                    if (v == p)
                        continue;
                    if (visited[v]) {
                        // lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                        lowlink[u] = Math.min(lowlink[u], tin[v]);
                    } else {
                        dfs(v, u);
                        lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                        cutPoint |= lowlink[v] >= tin[u];
                        // if (lowlink[v] == tin[v])
                        if (lowlink[v] > tin[u])
                            bridges.add(new Pair(u, v));
                        ++children;
                    }
                }
                if (p == -1)
                    cutPoint = children >= 2;
                if (cutPoint)
                    cutPoints.add(u);
                if (lowlink[u] == tin[u]) {
                    List<Integer> component = new ArrayList<>();
                    while (true) {
                        int x = stack.pop();
                        component.add(x);
                        if (x == u)
                            break;
                    }
                    components.add(component);
                }
            }
        }

		/* ---------------------------------------------- */

        public List<Integer> topologicalSort() {
            int n = graph.length;
            boolean[] used = new boolean[n];
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                if (!used[i])
                    dfs(graph, used, res, i);
            Collections.reverse(res);
            return res;
        }

		/* ---------------------------------------------- */

        public long MinimumSpanningTreeValueElogV() {
            return mst(edges, new long[edges.length]);
        }

        private long mst(List<Edge>[] edges, long[] pred) {
            int n = edges.length;
            Arrays.fill(pred, -1);
            boolean[] used = new boolean[n];
            long[] prio = new long[n];
            Arrays.fill(prio, Integer.MAX_VALUE);
            prio[0] = 0;
            PriorityQueue<Long> q = new PriorityQueue<>();
            q.add(0L);
            long res = 0;

            while (!q.isEmpty()) {
                long cur = q.poll();
                int u = (int) cur;
                if (used[u])
                    continue;
                used[u] = true;
                res += cur >>> 32;
                for (Edge e : edges[u]) {
                    int v = e.v;
                    if (!used[v] && prio[v] > e.cost) {
                        prio[v] = e.cost;
                        pred[v] = u;
                        q.add(((long) prio[v] << 32) + v);
                    }
                }
            }
            return res;
        }

		/* ---------------------------------------------- */

        public long MinimumSpanningTreeValueV2() {
            long[][] dist = new long[edges.length][edges.length];

            for (int i = 0; i < edges.length; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
                for (Edge e : edges[i]) {
                    dist[i][e.v] = e.cost;
                }
            }
            return mstPrim(dist);
        }

        private long mstPrim(long[][] d) {
            int n = d.length;
            int[] prev = new int[n];
            long[] dist = new long[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            boolean[] visited = new boolean[n];
            long res = 0;
            for (int i = 0; i < n; i++) {
                int u = -1;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && (u == -1 || dist[u] > dist[j]))
                        u = j;
                }
                res += dist[u];
                visited[u] = true;
                for (int j = 0; j < n; j++) {
                    if (!visited[j] && dist[j] > d[u][j]) {
                        dist[j] = d[u][j];
                        prev[j] = u;
                    }
                }
            }
            return res;
        }

		/* ---------------------------------------------- */

        static final long INF = Long.MAX_VALUE / 2;

        public long[] bellmanFord(int s) {
            long[] ans = new long[edges.length];
            int[] pred = new int[edges.length];
            if (bellmanFord(s, ans, pred)) {
                return ans;
            }
            return null;
        }

        private boolean bellmanFord(int s, long[] dist, int[] pred) {
            Arrays.fill(pred, -1);
            Arrays.fill(dist, INF);
            dist[s] = 0;
            int n = edges.length;
            boolean updated = false;
            for (int step = 0; step < n; step++) {
                updated = false;
                for (int u = 0; u < n; u++) {
                    if (dist[u] == INF)
                        continue;
                    for (Edge e : edges[u]) {
                        if (dist[e.v] > dist[u] + e.cost) {
                            dist[e.v] = dist[u] + e.cost;
                            dist[e.v] = Math.max(dist[e.v], -INF);
                            pred[e.v] = u;
                            updated = true;
                        }
                    }
                }
                if (!updated)
                    break;
            }
            // if updated is true then a negative cycle exists
            return updated == false;
        }

        public int[] findNegativeCycle() {
            int n = edges.length;
            int[] pred = new int[n];
            Arrays.fill(pred, -1);
            long[] dist = new long[n];
            int last = -1;
            for (int step = 0; step < n; step++) {
                last = -1;
                for (int u = 0; u < n; u++) {
                    if (dist[u] == INF)
                        continue;
                    for (Edge e : edges[u]) {
                        if (dist[e.v] > dist[u] + e.cost) {
                            dist[e.v] = Math.max(dist[u] + e.cost, -INF);
                            dist[e.v] = Math.max(dist[e.v], -INF);
                            pred[e.v] = u;
                            last = e.v;
                        }
                    }
                }
                if (last == -1)
                    return null;
            }
            for (int i = 0; i < n; i++) {
                last = pred[last];
            }
            int[] p = new int[n];
            int cnt = 0;
            for (int u = last; u != last || cnt == 0; u = pred[u]) {
                p[cnt++] = u;
            }
            int[] cycle = new int[cnt];
            for (int i = 0; i < cycle.length; i++) {
                cycle[i] = p[--cnt];
            }
            return cycle;
        }

		/* ---------------------------------------------- */

		/*
		 * row 0 - return values of distance row 1 - return previous node
		 */

        public long[][] dijkstra(int start) {
            long[][] ans = new long[2][edges.length];
            shortestPaths(start, ans[0], ans[1]);
            // shortestPaths2(start, ans[0], ans[1]); for long values in cost;
            return ans;
        }

        private void shortestPaths(int s, long[] prio, long[] pred) {
            Arrays.fill(pred, -1);
            Arrays.fill(prio, Integer.MAX_VALUE);
            prio[s] = 0;
            PriorityQueue<Long> q = new PriorityQueue<>();
            q.add((long) s);
            while (!q.isEmpty()) {
                long cur = q.remove();
                int curu = (int) cur;
                if (cur >>> 32 != prio[curu])
                    continue;
                for (Edge e : edges[curu]) {
                    int v = e.v;
                    long nprio = prio[curu] + e.cost;
                    if (prio[v] > nprio) {
                        prio[v] = nprio;
                        pred[v] = curu;
                        q.add(((long) nprio << 32) + v);
                    }
                }
            }
        }

		/* ---------------------------------------------- */

        public List<Integer> findCenters() {
            int n = graph.length;
            List<Integer> leaves = new ArrayList<>();
            int[] degree = new int[n];
            for (int i = 0; i < n; i++) {
                degree[i] = graph[i].size();
                if (degree[i] <= 1) {
                    leaves.add(i);
                }
            }
            int removedLeaves = leaves.size();
            while (removedLeaves < n) {
                List<Integer> nleaves = new ArrayList<>();
                for (int u : leaves) {
                    for (int v : graph[u]) {
                        if (--degree[v] == 1) {
                            nleaves.add(v);
                        }
                    }
                }
                leaves = nleaves;
                removedLeaves += leaves.size();
            }
            return leaves;
        }

        public int findCentroid() {
            return findCentroid(0, -1);
        }

        // returns vertex that has all its subtrees sizes <= n/2
        private int findCentroid(int u, int p) {
            int n = graph.length;
            int cnt = 1;
            boolean goodCenter = true;
            for (int v : graph[u]) {
                if (v == p)
                    continue;
                int res = findCentroid(v, u);
                if (res >= 0)
                    return res;
                int size = -res;
                goodCenter &= size <= n / 2;
                cnt += size;
            }
            goodCenter &= n - cnt <= n / 2;
            return goodCenter ? u : -cnt;
        }

        public int diameter() {
            int furthestVertex = (int) dfs(graph, 0, -1, 0);
            return (int) (dfs(graph, furthestVertex, -1, 0) >>> 32);
        }

        private long dfs(List<Integer>[] tree, int u, int p, int depth) {
            long res = ((long) depth << 32) + u;
            for (int v : tree[u])
                if (v != p)
                    res = Math.max(res, dfs(tree, v, u, depth + 1));
            return res;
        }

		/* -------------------------------- */

        public int maxMatchingEV(int n1, int n2) {
            int[] matching = new int[n2];
            Arrays.fill(matching, -1);
            int matches = 0;
            for (int u = 0; u < n1; u++) {
                if (findPath(graph, u, matching, new boolean[n1]))
                    ++matches;
            }
            return matches;
        }

        private boolean findPath(List<Integer>[] graph, int u1, int[] matching,
                                 boolean[] vis) {
            vis[u1] = true;
            for (int v : graph[u1]) {
                int u2 = matching[v];
                if (u2 == -1 || !vis[u2] && findPath(graph, u2, matching, vis)) {
                    matching[v] = u1;
                    return true;
                }
            }
            return false;
        }
    }

}
