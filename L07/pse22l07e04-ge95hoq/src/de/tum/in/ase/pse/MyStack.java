package de.tum.in.ase.pse;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    /**
     * TODO: Replace inheritance with delegation!
     * Task 1: Create a field for the delegate.
     * Tasks 2-4: Adapt the implementation of existing methods
     * Task 5: Provide a method isEmpty().
     * <p>
     * Hint: use the test implementation in the main method to verify your progress.
     */
    private final List<T> delegate = new ArrayList<>();

    public void push(T element) {
        delegate.add(element);
    }

    public T pop() {
        return delegate.remove(delegate.size() - 1);
    }

    public T top() {
        return delegate.get(delegate.size() - 1);
    }

    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    public static void main(String[] argv) {
        MyStack<String> stack = new MyStack<>();

        System.out.println("Stack is " + (stack.isEmpty() ? "" : "not ") + "empty.");

        stack.push("First Element");
        stack.push("Second Element");
        stack.push("Third Element");

        System.out.println("This is the top element: " + stack.top());
        System.out.println("Stack is " + (stack.isEmpty() ? "" : "not ") + "empty.");

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println("Stack is " + (stack.isEmpty() ? "" : "not ") + "empty.");
    }
}
