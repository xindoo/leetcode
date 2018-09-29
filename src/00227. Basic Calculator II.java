import java.util.ArrayList;
import java.util.List;

class Solution {
    public int calculate(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            }
            sb.append(c);
        }
        String s = sb.toString();
        List<Integer> nums = new ArrayList<>();
        List<Character> op = new ArrayList<>();
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c <= '9' && c >= '0') {
                n *= 10;
                n += c - '0';
            } else {
                op.add(c);
                nums.add(n);
                n = 0;
            }
        }
        nums.add(n);
        char pre = '+';
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == '*') {
                nums.set(i + 1, nums.get(i) * nums.get(i + 1));
                nums.set(i, 0);
                op.set(i, pre);
            } else if (op.get(i) == '/') {
                nums.set(i + 1, nums.get(i) / nums.get(i + 1));
                nums.set(i, 0);
                op.set(i, pre);
            } else {
                pre = op.get(i);
            }
        }

        int ans = nums.get(0);
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i) == '+') {
                ans += nums.get(i + 1);
            }
            if (op.get(i) == '-') {
                ans -= nums.get(i + 1);
            }
        }
        return ans;
    }
}