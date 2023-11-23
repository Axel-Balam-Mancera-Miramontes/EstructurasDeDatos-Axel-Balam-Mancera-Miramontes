/**
 * @author Axel Balam Mancera Miramontes
 */

import java.util.Stack;

public class StackTest {

    @Test
    public void pushTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(78);
        stack.push(105);
        Assert.assertTrue(stack.peek().get()==105);
        Assert.assertEquals(3,stack.size());
    }

    @Test
    public void popTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(78);
        stack.push(105);
        stack.pop();

        Assert.assertTrue(stack.peek().get() == 78);
        Assert.assertFalse(stack.peek().get()==105);
        Assert.assertEquals(2,stack.size());
    }

    @Test
    public void pop_empty_Test(){
        Stack<Integer> stack = new Stack<>();
        Optional<Integer> element = stack.pop();

        Assert.assertTrue(element.isEmpty());
        Assert.assertEquals(0,stack.size());
    }

    @Test
    public void peek_empty_Test(){
        Stack<Integer> stack = new Stack<>();
        Optional<Integer> element = stack.peek();

        Assert.assertTrue(element.isEmpty());
        Assert.assertEquals(0,stack.size());
    }

    @Test
    public void is_EmptyTest(){
        Stack<Integer> stack = new Stack<>();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void is_not_EmptyTest(){
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        Assert.assertFalse(stack.isEmpty());
    }
}