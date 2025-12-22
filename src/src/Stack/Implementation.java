package Stack;
import java.util.*;
public class Implementation {
    public static void main(String[] args) {
        StackBF s1 = new StackBF(5);
        s1.push(10);
        s1.push(20);
        System.out.println(s1.peek()); // 20
        s1.pop();
        System.out.println(s1.peek()); // 10

        StackOpt s2 = new StackOpt();
        s2.push(100);
        s2.push(200);
        System.out.println(s2.peek()); // 200
        s2.pop();
        System.out.println(s2.peek()); // 100
    }


    static class StackBF {
        int[] arr;
        int top;

        StackBF(int size) {
            arr = new int[size];
            top = -1;
        }

        boolean push(int x) {
            if (top == arr.length - 1) return false;
            arr[++top] = x;
            return true;
        }

        boolean pop() {
            if (top == -1) return false;
            top--;
            return true;
        }

        int peek() {
            return top == -1 ? -1 : arr[top];
        }

        boolean isEmpty() {
            return top == -1;
        }
    }

   static class StackOpt {
        ArrayList<Integer> arr = new ArrayList<>();

        void push(int x) { arr.add(x); }

        boolean pop() {
            if (arr.isEmpty()) return false;
            arr.removeLast();
            return true;
        }

        int peek() {
            return arr.isEmpty() ? -1 : arr.getLast();
        }

        boolean isEmpty() {
            return arr.isEmpty();
        }
    }

}
