package String;

public class ValidPalindrome {

    // Brute force: clean string then reverse
    static boolean validPalBF(String s) {
        StringBuilder clean = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }
        String rev = clean.reverse().toString();
        clean.reverse(); // restore
        return clean.toString().equals(rev);
    }

    // Optimized: two pointers
    static boolean validPalOpt(String s) {
        int l = 0, r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) l++;
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) r--;

            if (Character.toLowerCase(s.charAt(l)) !=
                    Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println("BF: " + validPalBF(s));
        System.out.println("Opt: " + validPalOpt(s));
    }
}

