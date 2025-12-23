package HashMap.Hashmap3;

import java.util.*;

public class ValidAnagram {

    // Brute Force
    static boolean isAnagramBF(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    // Optimized frequency count
    static boolean isAnagramOpt(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (char c : s.toCharArray())
            count[c - 'a']++;

        for (char c : t.toCharArray())
            if (--count[c - 'a'] < 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagramOpt("anagram", "nagaram")); // true
        System.out.println(isAnagramOpt("rat", "car"));         // false
    }
}
