/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数.
 */

import java.util.Stack;
public class Offer21 {

}

class Solution {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            if (node <= minStack.peek()) {
                minStack.push(node);
            } else {
                minStack.push(minStack.peek());
            }
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }


}