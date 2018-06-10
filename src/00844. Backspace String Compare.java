import java.util.Arrays;
import java.util.Stack;

class Solution {
    public String reFormat(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        return stack.toString();
    }
    public boolean backspaceCompare(String S, String T) {
        String s = reFormat(S);
        String t = reFormat(T);
        return s.equals(t);
    }
}