package Matrix;

import java.util.*;

public class RowWithMaxOnes {

    static int maxRowBF(int[][] mat) {
        int max = -1, idx = -1;
        for (int i = 0; i < mat.length; i++) {
            int cnt = 0;
            for (int x : mat[i]) if (x == 1) cnt++;
            if (cnt > max) {
                max = cnt;
                idx = i;
            }
        }
        return idx;
    }

    static int maxRowOpt(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int j = c - 1, ans = -1;
        for (int i = 0; i < r; i++) {
            while (j >= 0 && mat[i][j] == 1) j--;
            if (j < c - 1) ans = i;
        }
        return ans;
    }
}
