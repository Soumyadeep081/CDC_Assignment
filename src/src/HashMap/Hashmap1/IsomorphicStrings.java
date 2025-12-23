package HashMap.Hashmap1;
import java.util.*;

public class IsomorphicStrings {

    // Brute Force
    public static boolean isIsomorphicBF(String s, String t) {
        if (s.length() != t.length()) return false;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if ((s.charAt(i) == s.charAt(j)) !=
                        (t.charAt(i) == t.charAt(j)))
                    return false;
            }
        }
        return true;
    }

    // Optimized using two hash maps
    public static boolean isIsomorphicOpt(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (sToT.containsKey(a) && sToT.get(a) != b) return false;
            if (tToS.containsKey(b) && tToS.get(b) != a) return false;

            sToT.put(a, b);
            tToS.put(b, a);
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";

        System.out.println("BF (egg, add): " + isIsomorphicBF(s1, t1));
        System.out.println("Opt (egg, add): " + isIsomorphicOpt(s1, t1));

        System.out.println("BF (foo, bar): " + isIsomorphicBF(s2, t2));
        System.out.println("Opt (foo, bar): " + isIsomorphicOpt(s2, t2));
    }
}
