package Stack;

import java.util.*;

public class SmallerElementToLeft {
    public static void main(String[] args) {
        int[] arr = {1, 3, 0, 2, 5};

        System.out.println(Arrays.toString(smallerLeftBF(arr)));
        System.out.println(Arrays.toString(smallerLeftOpt(arr)));
    }
    static int[] smallerLeftBF(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    res[i] = arr[j];
                    break;
                }
            }
        }
        return res;
    }

    static int[] smallerLeftOpt(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
