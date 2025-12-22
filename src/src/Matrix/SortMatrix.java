package Matrix;

import java.util.*;

public class SortMatrix {

    static List<Integer> sortedBF(int[][] mat) {
        List<Integer> res = new ArrayList<>();
        for (int[] row : mat)
            for (int x : row) res.add(x);
        Collections.sort(res);
        return res;
    }

    static List<Integer> sortedOpt(int[][] mat) {
        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> mat[a[0]][a[1]]));
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < mat.length; i++)
            pq.add(new int[]{i, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1];
            res.add(mat[r][c]);
            if (c + 1 < mat[r].length)
                pq.add(new int[]{r, c + 1});
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1,3,5},{2,4,6},{7,8,9}};
        System.out.println(sortedBF(mat));
        System.out.println(sortedOpt(mat));
    }
}
