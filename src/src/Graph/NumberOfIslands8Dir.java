package Graph;
import java.util.*;

public class NumberOfIslands8Dir {

    static int[] dx = {-1,0,1,0,-1,-1,1,1};
    static int[] dy = {0,1,0,-1,-1,1,-1,1};

    static void dfs(int x, int y, char[][] grid, boolean[][] vis) {
        vis[x][y] = true;
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length &&
                    grid[nx][ny] == '1' && !vis[nx][ny]) {
                dfs(nx, ny, grid, vis);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.next().charAt(0);

        boolean[][] vis = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == '1' && !vis[i][j]) {
                    islands++;
                    dfs(i, j, grid, vis);
                }

        System.out.println(islands);
    }
}
