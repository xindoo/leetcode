import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            }
            else {
                char c = stack.peek();
                if ( c == '(') {
                    if (s.charAt(i) == ')') {
                        stack.pop();
                    }else {
                        stack.push(s.charAt(i));
                    }

                } else if ( c == '[') {
                    if (s.charAt(i) == ']') {
                        stack.pop();
                    }else {
                        stack.push(s.charAt(i));
                    }
                } else if ( c == '{') {
                    if (s.charAt(i) == '}') {
                        stack.pop();
                    }else {
                        stack.push(s.charAt(i));
                    }
                } else {
                    stack.push(s.charAt(i));
                }
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }
}