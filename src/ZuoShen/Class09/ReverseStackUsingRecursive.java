package ZuoShen.Class09;

import java.util.Stack;

public class ReverseStackUsingRecursive {
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack); //推理同下，自己推
        stack.push(i);
    }
    //获得并移除栈低元素  用栈顶向下1 2 3举例
    //result = 1 last=递归结果   last =》3 并把1压入  回溯
    //result = 2 last=递归结果   last =》3 并把2压入  回溯，维持原条件不变
    //result = 3
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void main(String[] args) {
        Stack<Integer> test = new Stack<Integer>();
        test.push(1);
        test.push(2);
        test.push(3);
        test.push(4);
        test.push(5);
        reverse(test);
        while (!test.isEmpty()) {
            System.out.println(test.pop());
        }

    }
}
