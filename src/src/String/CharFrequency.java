package String;

public class CharFrequency {

    // Brute force / Optimized (same)
    static int freqChar(String s, char c) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == c) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "hello world";
        char c = 'l';
        System.out.println("BF: " + freqChar(s, c));
        System.out.println("Opt: " + freqChar(s, c));
    }
}
