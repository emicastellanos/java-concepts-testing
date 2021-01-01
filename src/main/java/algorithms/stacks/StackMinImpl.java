package algorithms.stacks;

import java.util.Stack;
import java.lang.Comparable;
/**
 * This class should act as a stack but it also should contain logic
 * to return the minimum element with complexity in constant order.
 *
 * This implementation uses an extra stack to store the minimum value.
 * The space is O(n), time O(1)
 */
public class StackMinImpl<E extends Comparable> extends Stack<E> implements StackMin<E> {
    private Stack<E> stack;
    private Stack<E> stackMinimum;

    public StackMinImpl() {
        stack = new Stack();
        stackMinimum = new Stack();
    }

    @Override
    public E push(E e) {
        stack.push(e);
        if (stackMinimum.empty() || e.compareTo(stackMinimum.peek()) == -1) {
            stackMinimum.push(e);
        } else {
            stackMinimum.push(stackMinimum.peek());
        }

        return e;
    }

    @Override
    public synchronized E pop() {
        stackMinimum.pop();
        return stack.pop();
    }

    @Override
    public synchronized E peek() {
        return stack.peek();
    }

    @Override
    public E getMinimum() {
        return stackMinimum.peek();
    }

}
