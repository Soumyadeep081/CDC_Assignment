package Stack;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";

        System.out.println(validParenOpt(s1)); // true
        System.out.println(validParenOpt(s2)); // false
    }


    static boolean validParenBF(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) st.push(c);
        StringBuilder rev = new StringBuilder();
        while (!st.isEmpty()) rev.append(st.pop());
        return s.equals(rev.toString());
    }

    static boolean validParenOpt(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') st.push(c);
            else {
                if (st.isEmpty()) return false;
                char t = st.pop();
                if ((c == ')' && t != '(') ||
                        (c == '}' && t != '{') ||
                        (c == ']' && t != '['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
