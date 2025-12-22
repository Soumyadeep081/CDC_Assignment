package Matrix;

import java.util.*;

public class MedianInSortedMatrix {

    static int medianBF(int[][] mat) {
        List<Integer> vals = new ArrayList<>();
        for (int[] row : mat)
            for (int x : row) vals.add(x);
        Collections.sort(vals);
        return vals.get(vals.size() / 2);
    }

    static int countLE(int[] row, int mid) {
        int l = 0, r = row.length;
        while (l < r) {
            int m = (l + r) / 2;
            if (row[m] <= mid) l = m + 1;
            else r = m;
        }
        return l;
    }

    static int medianOpt(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int[] row : mat) {
            low = Math.min(low, row[0]);
            high = Math.max(high, row[c - 1]);
        }

        int need = (r * c + 1) / 2;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int cnt = 0;
            for (int[] row : mat) cnt += countLE(row, mid);
            if (cnt < need) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
