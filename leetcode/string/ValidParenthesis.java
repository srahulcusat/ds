package com.leetcode.string;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if ((ch == ')' || ch == '}' || ch == ']')) {
                if (stack.empty())
                    return false;

                char open = stack.pop();
                boolean flag = false;
                if (ch == ')' && open == '(') {
                    flag = true;
                } else if (ch == '}' && open == '{') {
                    flag = true;
                } else if (ch == ']' && open == '[') {
                    flag = true;
                }
                if (!flag)
                    return flag;
            } else {
                stack.push(ch);
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        /*
        Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
        determine if the input string is valid.
        An input string is valid if:

        Open brackets must be closed by the same type of brackets.
        Open brackets must be closed in the correct order.
        Every close bracket has a corresponding open bracket of the same type.
        */


        String s = "()[]{}";
        boolean result = isValid(s);
        System.out.println(result);
    }
}
