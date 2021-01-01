package algorithms.stacks;

import org.junit.Assert;
import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class StackMinImplTest {

    private StackMinImpl<Integer> stackToBeTested;

    @Test
    public void getMinimum() {
        stackToBeTested = new StackMinImpl();
        stackToBeTested.push(0);
        Assert.assertEquals(new Integer(0), stackToBeTested.getMinimum());
        stackToBeTested.push(2);
        Assert.assertEquals(new Integer(0), stackToBeTested.getMinimum());
        stackToBeTested.push(-1);
        Assert.assertEquals(new Integer(-1), stackToBeTested.getMinimum());
        stackToBeTested.push(3);
        Assert.assertEquals(new Integer(-1), stackToBeTested.getMinimum());
        stackToBeTested.push(1);
        Assert.assertEquals(new Integer(-1), stackToBeTested.getMinimum());
        stackToBeTested.push(-4);
        Assert.assertEquals(new Integer(-4), stackToBeTested.getMinimum());

        stackToBeTested.pop();
        Assert.assertEquals(new Integer(-1), stackToBeTested.getMinimum());
        stackToBeTested.pop();
        Assert.assertEquals(new Integer(-1), stackToBeTested.getMinimum());
        stackToBeTested.pop();
        stackToBeTested.pop();
        Assert.assertEquals(new Integer(0), stackToBeTested.getMinimum());
    }

    @Test(expected = EmptyStackException.class)
    public void popWhenThereAreNoElementsShouldThrowEmptyStackException() {
        stackToBeTested = new StackMinImpl();
        stackToBeTested.pop();
    }
}