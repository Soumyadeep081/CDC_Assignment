package Graph;
import java.util.*;

public class CycleDetectionUndirected {

    static boolean dfs(int node, int parent, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, node, adj, visited)) return true;
            } else if (nei != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        boolean hasCycle = false;

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dfs(i, -1, adj, visited)) {
                hasCycle = true;
                break;
            }
        }

        System.out.println(hasCycle ? "Graph contains cycle" : "Graph does not contain cycle");
    }
}
