package Greedy;

import java.util.*;

public class AssignCookies {
    public static int findContentChildren(int[] greed, int[] size) {
        Arrays.sort(greed);
        Arrays.sort(size);

        int i = 0, j = 0, count = 0;

        while (i < greed.length && j < size.length) {
            if (size[j] >= greed[i]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int g = sc.nextInt();
        int s = sc.nextInt();

        int[] greed = new int[g];
        int[] size = new int[s];

        for (int i = 0; i < g; i++) greed[i] = sc.nextInt();
        for (int i = 0; i < s; i++) size[i] = sc.nextInt();

        System.out.println(findContentChildren(greed, size));
    }
}
