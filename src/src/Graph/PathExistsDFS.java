package Graph;
import java.util.*;

public class PathExistsDFS {

    static boolean dfs(int node, int end, List<List<Integer>> adj, boolean[] visited) {
        if (node == end) return true;
        visited[node] = true;
        for (int nei : adj.get(node)) {
            if (!visited[nei] && dfs(nei, end, adj, visited)) return true;
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

        int start = sc.nextInt(), end = sc.nextInt();
        boolean[] visited = new boolean[n];

        System.out.println(dfs(start, end, adj, visited)
                ? "Path exists"
                : "No path exists");
    }
}
