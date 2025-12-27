package com.lecture.apnacollege.dsa2.stack;

import java.util.Stack;

public class CollectionStacks {


    public static void reverseStack(Stack<Integer> stack){

        if(stack.isEmpty())
            return;
       //  1 2 3 4 ->  4 3 2 ->
        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(top,stack);

    }

    public static void pushAtBottom(int data,Stack<Integer> stack){

        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int top =  stack.pop();
        pushAtBottom(data,stack);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

//        pushAtBottom(4,stack);
        reverseStack(stack);

        while (!stack.isEmpty()){
            System.out.println(stack.peek());
            stack.pop();
        }
    }
}
