// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// push(x) -- Push element x onto stack.
// pop() -- Removes the element on top of the stack.
// top() -- Get the top element.
// getMin() -- Retrieve the minimum element in the stack.

import java.util.*;

public class MinStack{
	private Stack<Integer> stack;
	private Stack<Integer> minStack;

	public MinStack(){
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
	}

	public void push(int x){
		stack.push(x);
		if(minStack.isEmpty() || x <= minStack.peek()){	// NOTE: must be "<="
			minStack.push(x);
		}
	}

	public int pop(){
		int x = stack.pop();
		if(x == minStack.peek()){
			minStack.pop();
		}
		return x;
	}

	public int top(){
		return stack.peek();
	}

	public int getMin(){
		return minStack.peek();
	}
}
