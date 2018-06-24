import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String S) {
        if (S.length() == 0)
            return 0;
        if (S.length() == 2)
            return 1;
        Stack<Character> stack = new Stack<>();
        int s = 0, e = 0;
        int cntStackEmpty = 0;
        int res = 0;
        while (e < S.length()) {
            if (stack.empty()) {
                if (e != 0 || cntStackEmpty > 1) {
                    res += scoreOfParentheses(S.substring(s, e));
                    s = e;
                }
                stack.push(S.charAt(e++));
                cntStackEmpty++;
            }
            if (S.charAt(e++) == '(') {
                stack.push('(');
            } else {
                stack.pop();
            }
        }
        if (cntStackEmpty  <= 1)
            return 2*scoreOfParentheses(S.substring(1, S.length()-1));
        else
            return res += scoreOfParentheses(S.substring(s, e));
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.scoreOfParentheses("((((()))))"));
    }
}