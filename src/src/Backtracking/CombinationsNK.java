package Backtracking;

import java.util.*;

public class CombinationsNK {

    private static void combineHelper(int n, int k, int start,
                                      List<Integer> temp,
                                      List<List<Integer>> res) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i <= n; i++) {
            temp.add(i);
            combineHelper(n, k, i + 1, temp, res);
            temp.remove(temp.size() - 1); // backtrack
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        combineHelper(n, k, 1, new ArrayList<>(), res);
        return res;
    }

    private static void printCombinations(List<List<Integer>> combinations) {
        for (List<Integer> combo : combinations) {
            System.out.print("{");
            for (int i = 0; i < combo.size(); i++) {
                System.out.print(combo.get(i));
                if (i < combo.size() - 1) System.out.print(",");
            }
            System.out.print("} ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Test Case 1: n=4, k=2");
        printCombinations(combine(4, 2));

        System.out.println("\nTest Case 2: n=3, k=3");
        printCombinations(combine(3, 3));

        System.out.println("\nTest Case 3: n=5, k=1");
        printCombinations(combine(5, 1));
    }
}
