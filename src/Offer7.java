import java.util.Stack;

public class Offer7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }

        if (stack2.empty()) {
            return Integer.MAX_VALUE;//应该是跑出异常的
        } else {
            return stack2.pop();
        }
    }
}
