package String;

public class RemoveNonAlphabet {

    // Brute force / Optimized (same)
    static String removeNonAlpha(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "Hello, 123 World!";
        System.out.println(removeNonAlpha(s));
    }
}
