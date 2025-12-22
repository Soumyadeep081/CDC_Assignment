package String;

import java.util.StringTokenizer;

public class CountWords {

    // Brute force: manual parsing
    static int countWordsBF(String s) {
        int count = 0;
        StringBuilder word = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (word.length() > 0) count++;
                word.setLength(0);
            } else {
                word.append(c);
            }
        }
        if (word.length() > 0) count++;
        return count;
    }

    // Optimized: using tokenizer (similar to stringstream)
    static int countWordsOpt(String s) {
        StringTokenizer st = new StringTokenizer(s);
        return st.countTokens();
    }

    public static void main(String[] args) {
        String s = "  Hello   world  this is   a test \n";
        System.out.println("BF: " + countWordsBF(s));
        System.out.println("Opt: " + countWordsOpt(s));
    }
}
