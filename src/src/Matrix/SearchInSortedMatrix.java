package Matrix;

import java.util.*;

public class SearchInSortedMatrix {

    static boolean searchBF(int[][] mat, int target) {
        for (int[] row : mat)
            for (int x : row)
                if (x == target) return true;
        return false;
    }

    static boolean searchOpt(int[][] mat, int target) {
        int r = 0, c = mat[0].length - 1;
        while (r < mat.length && c >= 0) {
            if (mat[r][c] == target) return true;
            if (mat[r][c] > target) c--;
            else r++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,4,7,11},{2,5,8,12},{3,6,9,16}};
        System.out.println(searchBF(mat, 5) ? "BF found" : "BF not found");
        System.out.println(searchOpt(mat, 5) ? "Opt found" : "Opt not found");
    }
}
