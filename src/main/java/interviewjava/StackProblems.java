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
}
