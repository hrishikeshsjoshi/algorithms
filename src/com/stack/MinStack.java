package com.stack;

import java.util.Stack;

public class MinStack {

  // private Stack<Integer> stack = new Stack();
  // private int min;
  public static void main(String[] args) {
    // 4, 10 ,-1, 5, 7 , 1, 7, 9 , -2, 11
    MinStack minStack = new MinStack();
    minStack.push(3);
    System.err.println("top = " + minStack.top());
    System.err.println("min=" + minStack.getMin());
    minStack.push(7);
    System.err.println("top = " + minStack.top());
    System.err.println("min=" + minStack.getMin());
    minStack.push(1);
    System.err.println("top = " + minStack.top());
    System.err.println("min=" + minStack.getMin());
    minStack.pop();
    System.err.println("top = " + minStack.top());
    System.err.println("min=" + minStack.getMin());
    minStack.pop();
    System.err.println("top = " + minStack.top());
    System.err.println("min=" + minStack.getMin());

  }

  int min = Integer.MAX_VALUE;
  Stack<Integer> stack = new Stack<Integer>();

  public void push(int x) {
    // only push the old minimum value when the current
    // minimum value changes after pushing the new value x
    if (x <= min) {
      stack.push(min);
      min = x;
    }
    stack.push(x);
  }

  public void pop() {
    // if pop operation could result in the changing of the current minimum value,
    // pop twice and change the current minimum value to the last minimum value.
    if (stack.pop() == min) {
      min = stack.pop();
    }
  }

  public int top() {
    return stack.peek();
  }

  public int getMin() {
    return min;
  }

}
