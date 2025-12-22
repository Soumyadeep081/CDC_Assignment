package Recursion.Advance;
public class StringPermutations {

    // Recursive function to generate permutations
    static void permute(char[] s, int l, int r) {
        // Base case: reached end
        if (l == r) {
            System.out.print(new String(s) + " ");
            return;
        }

        // Fix each character at position l
        for (int i = l; i <= r; i++) {
            swap(s, l, i);          // place character
            permute(s, l + 1, r);  // recurse
            swap(s, l, i);          // backtrack
        }
    }

    // Helper swap function
    static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {

        // Test Case 1
        System.out.println("Test Case 1: abc");
        String s1 = "abc";
        System.out.print("All permutations: ");
        permute(s1.toCharArray(), 0, s1.length() - 1);
        System.out.println();

        // Test Case 2
        System.out.println("\nTest Case 2: xy");
        String s2 = "xy";
        System.out.print("All permutations: ");
        permute(s2.toCharArray(), 0, s2.length() - 1);
        System.out.println();

        // Test Case 3
        System.out.println("\nTest Case 3: a");
        String s3 = "a";
        System.out.print("All permutations: ");
        permute(s3.toCharArray(), 0, s3.length() - 1);
        System.out.println();
    }
}
