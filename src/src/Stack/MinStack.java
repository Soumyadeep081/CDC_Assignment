package Stack;

import java.util.*;
public class MinStack{
    public static void main(String[] args) {
        MinStackBF s = new MinStackBF();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin()); // 3
        s.push(2);
        s.push(1);
        System.out.println(s.getMin()); // 1
        s.pop();
        System.out.println(s.top() + " " + s.getMin()); // 2 2
    }

}
class MinStackBF {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minS = new Stack<>();

    void push(int x) {
        s.push(x);
        if (minS.isEmpty() || x <= minS.peek()) minS.push(x);
    }

    void pop() {
        if (s.peek().equals(minS.peek())) minS.pop();
        s.pop();
    }

    int top() { return s.peek(); }

    int getMin() { return minS.peek(); }
}

class MinStackOpt {
    Stack<Integer> s = new Stack<>();

    void push(int x) { s.push(x); }

    void pop() { s.pop(); }

    int top() { return s.peek(); }

    int getMin() {
        Stack<Integer> tmp = new Stack<>();
        int min = Integer.MAX_VALUE;
        while (!s.isEmpty()) {
            min = Math.min(min, s.peek());
            tmp.push(s.pop());
        }
        while (!tmp.isEmpty()) s.push(tmp.pop());
        return min;
    }
}
