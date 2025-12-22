package String;

public class CountVowelsConsonants {

    // Brute force / Optimized (same)
    static int[] countVC(String s) {
        int vowels = 0, consonants = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        String s = "Hello, World!";
        int[] res = countVC(s);
        System.out.println("Vowels: " + res[0] + ", Consonants: " + res[1]);
    }
}
