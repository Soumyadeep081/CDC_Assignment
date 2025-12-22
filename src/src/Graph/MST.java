package Graph;
import java.util.*;

class Edge {
    int u, v, w;
    Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
}

class DSU {
    int[] parent, rank;
    DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    boolean union(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return false;
        if (rank[x] < rank[y]) parent[x] = y;
        else if (rank[x] > rank[y]) parent[y] = x;
        else { parent[y] = x; rank[x]++; }
        return true;
    }
}

public class MST {

    static List<Edge> kruskal(List<Edge> edges, int V) {
        edges.sort(Comparator.comparingInt(e -> e.w));
        DSU dsu = new DSU(V);
        List<Edge> mst = new ArrayList<>();
        for (Edge e : edges)
            if (dsu.union(e.u, e.v)) mst.add(e);
        return mst;
    }

    static List<Edge> prim(List<List<int[]>> graph, int V) {
        int[] key = new int[V];
        int[] parent = new int[V];
        boolean[] mst = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int u = pq.poll()[1];
            mst[u] = true;
            for (int[] e : graph.get(u)) {
                int v = e[0], w = e[1];
                if (!mst[v] && w < key[v]) {
                    key[v] = w;
                    parent[v] = u;
                    pq.add(new int[]{key[v], v});
                }
            }
        }

        List<Edge> res = new ArrayList<>();
        for (int i = 1; i < V; i++)
            res.add(new Edge(parent[i], i, key[i]));
        return res;
    }
}
