package Arrays.Array3;

import java.util.*;

public class UnionIntersection {

    // Brute force
    public static Pair<List<Integer>, List<Integer>> uniInterBF(int[] a, int[] b) {
        List<Integer> uni = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();

        List<Integer> merged = new ArrayList<>();
        for (int x : a) merged.add(x);
        for (int x : b) merged.add(x);

        Collections.sort(merged);

        for (int i = 0; i < merged.size(); i++) {
            if (i == 0 || !merged.get(i).equals(merged.get(i - 1))) {
                uni.add(merged.get(i));
            }
        }

        for (int x : a) {
            for (int y : b) {
                if (x == y && (inter.isEmpty() || inter.get(inter.size() - 1) != x)) {
                    inter.add(x);
                    break;
                }
            }
        }
        return new Pair<>(uni, inter);
    }

    // Optimized two-pointer
    public static Pair<List<Integer>, List<Integer>> uniInterOpt(int[] a, int[] b) {
        List<Integer> uni = new ArrayList<>();
        List<Integer> inter = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                if (uni.isEmpty() || uni.get(uni.size() - 1) != a[i])
                    uni.add(a[i]);
                if (inter.isEmpty() || inter.get(inter.size() - 1) != a[i])
                    inter.add(a[i]);
                i++; j++;
            } else if (a[i] < b[j]) {
                if (uni.isEmpty() || uni.get(uni.size() - 1) != a[i])
                    uni.add(a[i]);
                i++;
            } else {
                if (uni.isEmpty() || uni.get(uni.size() - 1) != b[j])
                    uni.add(b[j]);
                j++;
            }
        }

        while (i < a.length) {
            if (uni.isEmpty() || uni.get(uni.size() - 1) != a[i])
                uni.add(a[i]);
            i++;
        }

        while (j < b.length) {
            if (uni.isEmpty() || uni.get(uni.size() - 1) != b[j])
                uni.add(b[j]);
            j++;
        }

        return new Pair<>(uni, inter);
    }
}

// Simple Pair helper
class Pair<U, V> {
    public U first;
    public V second;
    Pair(U f, V s) { first = f; second = s; }
}
