package Recursion.Advance;

public class GenerateSubsets {

    // Recursive function to generate all subsets
    static void generateSubsets(String s, String curr, int index) {
        // Base case: reached end of string
        if (index == s.length()) {
            // Print empty subset clearly
            if (curr.isEmpty()) {
                System.out.print("{} ");
            } else {
                System.out.print(curr + " ");
            }
            return;
        }

        // Include current character
        generateSubsets(s, curr + s.charAt(index), index + 1);

        // Exclude current character
        generateSubsets(s, curr, index + 1);
    }

    public static void main(String[] args) {

        // Test Case 1
        System.out.println("Test Case 1: abc");
        String s1 = "abc";
        System.out.print("All subsets: ");
        generateSubsets(s1, "", 0);
        System.out.println();

        // Test Case 2
        System.out.println("\nTest Case 2: xy");
        String s2 = "xy";
        System.out.print("All subsets: ");
        generateSubsets(s2, "", 0);
        System.out.println();

        // Test Case 3
        System.out.println("\nTest Case 3: a");
        String s3 = "a";
        System.out.print("All subsets: ");
        generateSubsets(s3, "", 0);
        System.out.println();
    }
}
