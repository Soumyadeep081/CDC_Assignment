package HashMap.Hashmap1;

import java.util.*;

public class BullsAndCows {

    public static int[] bullsAndCows(String secret, String guess) {
        int bulls = 0, cows = 0;
        Map<Character, Integer> countSecret = new HashMap<>();
        Map<Character, Integer> countGuess = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                countSecret.put(secret.charAt(i),
                        countSecret.getOrDefault(secret.charAt(i), 0) + 1);
                countGuess.put(guess.charAt(i),
                        countGuess.getOrDefault(guess.charAt(i), 0) + 1);
            }
        }

        for (char ch : countSecret.keySet()) {
            cows += Math.min(
                    countSecret.get(ch),
                    countGuess.getOrDefault(ch, 0)
            );
        }
        return new int[]{bulls, cows};
    }

    public static void main(String[] args) {
        int[] res = bullsAndCows("1807", "7810");
        System.out.println("Bulls: " + res[0] + ", Cows: " + res[1]);
    }
}
