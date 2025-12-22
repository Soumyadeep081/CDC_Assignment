package Graph;

import java.util.*;

public class ClosedIslands {

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void dfs(int x, int y, int[][] grid, boolean[][] vis) {
        vis[x][y] = true;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m &&
                    grid[nx][ny] == 1 && !vis[nx][ny]) {
                dfs(nx, ny, grid, vis);
            }
        }
    }

    static int closedIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1) dfs(i, 0, grid, vis);
            if (grid[i][m - 1] == 1) dfs(i, m - 1, grid, vis);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1) dfs(0, j, grid, vis);
            if (grid[n - 1][j] == 1) dfs(n - 1, j, grid, vis);
        }

        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1 && !vis[i][j]) {
                    count++;
                    dfs(i, j, grid, vis);
                }
        return count;
    }
}
