package BinarySearch;

public class FirstBadVersion {

    // Mock API
    static boolean isBadVersion(int v) {
        return v >= 4; // example: versions 4..n are bad
    }

    // Brute force
    public static int firstBadVersionBF(int n) {
        for (int i = 1; i <= n; i++) {
            if (isBadVersion(i)) return i;
        }
        return -1;
    }

    // Optimized: binary search
    public static int firstBadVersionOpt(int n) {
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println("BF: " + firstBadVersionBF(n));
        System.out.println("Opt: " + firstBadVersionOpt(n));
    }
}

