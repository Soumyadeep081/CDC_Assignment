package String;

import java.util.*;

public class RemoveDuplicateCharacters {

    // Brute force: O(n^2)
    static String rmDupBF(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (res.indexOf(String.valueOf(c)) == -1) {
                res.append(c);
            }
        }
        return res.toString();
    }

    // Optimized: O(n)
    static String rmDupOpt(String s) {
        Set<Character> seen = new HashSet<>();
        StringBuilder res = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        System.out.println("BF: " + rmDupBF(s));
        System.out.println("Opt: " + rmDupOpt(s));
    }
}
