package Matrix;

import java.util.*;

public class RotateMatrix {

    static int[][] rotateBF(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[][] res = new int[c][r];
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                res[j][r - 1 - i] = mat[i][j];
        return res;
    }

    static void rotateOpt(int[][] mat) {
        int n = mat.length;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                int tmp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = tmp;
            }

        for (int i = 0; i < n; i++)
            for (int l = 0, r = n - 1; l < r; l++, r--) {
                int t = mat[i][l];
                mat[i][l] = mat[i][r];
                mat[i][r] = t;
            }
    }
}

