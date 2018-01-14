import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Solution {
    public List<Integer> grayCode(int n) {
        int sum = (int)Math.pow(2, n);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < sum; i++) {
            String s = Integer.toBinaryString(i);
            String tmp = "";
            int xor = 0;
            for (int j = 0; j < s.length(); j++) {
                tmp += (xor^Integer.parseInt(""+s.charAt(j)));
                xor = Integer.parseInt(""+s.charAt(j));
            }
            System.out.println(s+":"+tmp+":"+i);
            int a = Integer.parseInt(tmp, 2);
            ans.add(a);
        }
        return ans;
    }
}