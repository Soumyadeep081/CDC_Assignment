package HashMap.Hashmap3;

import java.util.*;

public class SetMatrixZeroes {

    // Brute Force
    static void setZeroesBF(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (rows[i] || cols[j])
                    matrix[i][j] = 0;
    }

    // Optimized O(1) space
    static void setZeroesOpt(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        boolean firstRow = false, firstCol = false;

        for (int j = 0; j < n; j++)
            if (matrix[0][j] == 0) firstRow = true;

        for (int i = 0; i < m; i++)
            if (matrix[i][0] == 0) firstCol = true;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                if (matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;

        if (firstRow)
            Arrays.fill(matrix[0], 0);

        if (firstCol)
            for (int i = 0; i < m; i++)
                matrix[i][0] = 0;
    }

    public static void main(String[] args) {
        int[][] mat = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        setZeroesOpt(mat);

        for (int[] row : mat) {
            for (int x : row) System.out.print(x + " ");
            System.out.println();
        }
    }
}
