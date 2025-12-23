package HashMap.Hashmap2;

import java.util.*;

public class HighestFrequencyChar {

    // Brute Force
    static char highestFreqCharBF(String s) {
        int maxFreq = 0;
        char res = '\0';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int freq = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == c) freq++;
            }
            if (freq > maxFreq) {
                maxFreq = freq;
                res = c;
            }
        }
        return res;
    }

    // Optimized
    static char highestFreqCharOpt(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray())
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        char res = '\0';
        int maxFreq = 0;
        for (var entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        System.out.println("BF: " + highestFreqCharBF(s));
        System.out.println("Opt: " + highestFreqCharOpt(s));
    }
}
