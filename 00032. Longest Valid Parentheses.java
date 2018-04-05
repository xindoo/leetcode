import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if (null == s || s.equals("")) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else  {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) {
            return s.length();
        }
        int r = s.length(), len = 0;
        while (!stack.isEmpty()) {
            len = Math.max(len, r-stack.peek()-1);
            r = stack.pop();
        }
        len = Math.max(len, r);
        return len;
    }
}