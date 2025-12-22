package Backtracking;

public class RatMazePathExists {

    private static boolean isSafe(int x, int y, int n, int[][] maze, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1 && !visited[x][y];
    }

    private static boolean solveMaze(int x, int y, int n, int[][] maze, boolean[][] visited) {
        if (x == n - 1 && y == n - 1) return true;

        visited[x][y] = true;

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isSafe(nx, ny, n, maze, visited)) {
                if (solveMaze(nx, ny, n, maze, visited)) return true;
            }
        }

        visited[x][y] = false;
        return false;
    }

    public static boolean pathExists(int[][] maze) {
        int n = maze.length;
        boolean[][] visited = new boolean[n][n];
        return maze[0][0] == 1 && solveMaze(0, 0, n, maze, visited);
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0},
                {0, 1}
        };

        System.out.println("Path exists: " + (pathExists(maze) ? "Yes" : "No"));
    }
}

