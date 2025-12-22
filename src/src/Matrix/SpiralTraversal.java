package Matrix;

import java.util.*;

public class SpiralTraversal {

    static List<Integer> spiralBF(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int r = 0, c = 0, d = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n * m; i++) {
            res.add(mat[r][c]);
            vis[r][c] = true;
            int nr = r + dirs[d][0], nc = c + dirs[d][1];
            if (nr < 0 || nc < 0 || nr >= n || nc >= m || vis[nr][nc])
                d = (d + 1) % 4;
            r += dirs[d][0];
            c += dirs[d][1];
        }
        return res;
    }

    static List<Integer> spiralOpt(int[][] mat) {
        int r1 = 0, r2 = mat.length - 1;
        int c1 = 0, c2 = mat[0].length - 1;
        List<Integer> res = new ArrayList<>();

        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) res.add(mat[r1][c]);
            r1++;
            for (int r = r1; r <= r2; r++) res.add(mat[r][c2]);
            c2--;
            if (r1 <= r2)
                for (int c = c2; c >= c1; c--) res.add(mat[r2][c]);
            r2--;
            if (c1 <= c2)
                for (int r = r2; r >= r1; r--) res.add(mat[r][c1]);
            c1++;
        }
        return res;
    }
}
