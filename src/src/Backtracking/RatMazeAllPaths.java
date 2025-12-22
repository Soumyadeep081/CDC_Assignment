package Backtracking;

import java.util.*;

public class RatMazeAllPaths {

    private static boolean isSafe(int x, int y, int n, int[][] maze, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < n && y < n && maze[x][y] == 1 && !visited[x][y];
    }

    private static void findAllPaths(
            int x, int y, int n,
            int[][] maze,
            boolean[][] visited,
            String path,
            List<String> res
    ) {
        if (x == n - 1 && y == n - 1) {
            res.add(path);
            return;
        }

        visited[x][y] = true;

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isSafe(nx, ny, n, maze, visited)) {
                findAllPaths(nx, ny, n, maze, visited, path + dir[k], res);
            }
        }

        visited[x][y] = false;
    }

    public static List<String> getAllPaths(int[][] maze) {
        int n = maze.length;
        List<String> res = new ArrayList<>();
        if (maze[0][0] == 0) return res;

        boolean[][] visited = new boolean[n][n];
        findAllPaths(0, 0, n, maze, visited, "", res);
        return res;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };

        List<String> paths = getAllPaths(maze);
        if (paths.isEmpty()) {
            System.out.println("No path exists");
        } else {
            for (String p : paths) System.out.println(p);
        }
    }
}

