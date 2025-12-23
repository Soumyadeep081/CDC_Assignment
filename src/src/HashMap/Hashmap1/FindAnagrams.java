package HashMap.Hashmap1;

import java.util.*;

public class FindAnagrams {

    // Brute Force
    public static List<Integer> findAnagramsBF(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length(), m = p.length();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);

        for (int i = 0; i <= n - m; i++) {
            char[] sub = s.substring(i, i + m).toCharArray();
            Arrays.sort(sub);
            if (Arrays.equals(sub, pArr)) {
                res.add(i);
            }
        }
        return res;
    }

    // Optimized Sliding Window
    public static List<Integer> findAnagramsOpt(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) pCount[c - 'a']++;

        for (int i = 0; i < p.length(); i++)
            sCount[s.charAt(i) - 'a']++;

        if (Arrays.equals(pCount, sCount)) res.add(0);

        for (int i = p.length(); i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            sCount[s.charAt(i - p.length()) - 'a']--;
            if (Arrays.equals(pCount, sCount))
                res.add(i - p.length() + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println("BF: " + findAnagramsBF(s, p));
        System.out.println("Opt: " + findAnagramsOpt(s, p));
    }
}
