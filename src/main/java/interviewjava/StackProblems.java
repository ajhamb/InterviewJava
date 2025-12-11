package interviewjava;

import java.util.Stack;

public class StackProblems {
    public String removeExtraBracket(String input) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(input);
        
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && input.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.deleteCharAt(index);
        }

        return sb.toString();
    }

    public int minParenthesisRemove(String input) {
        // Stack<Character> stack = new Stack<>();
        // int removeCount = 0;

        // for (char c : input.toCharArray()) {
        //     if (c == '(') {
        //         stack.push(c);
        //     } else if (c == ')') {
        //         if (!stack.isEmpty() && stack.peek() == '(') {
        //             stack.pop();
        //         } else {
        //             removeCount++;
        //         }
        //     }
        // }

        // removeCount += stack.size();
        // return removeCount;

        int removeCount = 0;
        int open = 0;

        for (char c : input.toCharArray()) {
            if (c == '(') {
                open++;
            } else if (c == ')') {
                if (open > 0) {
                    open --;
                } else {
                    removeCount++;
                }
            }
        }

        removeCount += open;
        return removeCount;

    }
}
