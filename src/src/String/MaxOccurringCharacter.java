package String;

import java.util.*;

public class MaxOccurringCharacter {

    // Brute force: O(n^2)
    static char maxOccCharBF(String s) {
        int maxCount = 0;
        char res = '\0';

        for (char c : s.toCharArray()) {
            int count = 0;
            for (char ch : s.toCharArray()) {
                if (ch == c) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                res = c;
            }
        }
        return res;
    }

    // Optimized: O(n)
    static char maxOccCharOpt(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        char res = '\0';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> e : freq.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                res = e.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abbcccddddeeeee";
        System.out.println("BF: " + maxOccCharBF(s));
        System.out.println("Opt: " + maxOccCharOpt(s));
    }
}
