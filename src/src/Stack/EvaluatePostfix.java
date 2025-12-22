package Stack;

import java.util.*;

public class EvaluatePostfix {
    static int evalPostfixOpt(String exp) {
        Stack<Integer> s = new Stack<>();
        for (char c : exp.toCharArray()) {
            if (Character.isDigit(c)) {
                s.push(c - '0');
            } else {
                int b = s.pop();
                int a = s.pop();
                switch (c) {
                    case '+': s.push(a + b); break;
                    case '-': s.push(a - b); break;
                    case '*': s.push(a * b); break;
                    case '/': s.push(a / b); break;
                }
            }
        }
        return s.peek();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("Eval postfix: " + evalPostfixOpt(exp));
    }
}
