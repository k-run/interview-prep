import java.util.Stack;

public class MyStack {
    Stack<Integer> stack;
    Integer min;

    public MyStack() {
        stack = new Stack<>();
    }

    public Integer getMin() {
        System.out.println("min = " + min);
        return min;
    }

    public void push(int x){
        int toPush = x;

        if(stack.isEmpty()) {
           stack.push(x);
           min = x;
           return;
        }

        if(x < min) {
            toPush = 2*x - min;
            min = x;
        }

        stack.push(toPush);
    }

    public void pop() {
        if(stack.isEmpty()) return;

        if(stack.peek() < min) {
            min = 2*min - stack.peek();
        }

        stack.pop();
    }
}
