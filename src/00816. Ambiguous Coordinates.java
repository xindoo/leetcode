import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private boolean vaildCheck(String str) {
        if ("0".equals(str))
            return true;
        if (str.contains(".") && str.endsWith("0") || str.startsWith("0") && !str.startsWith("0."))
            return false;
        return true;
    }

    private List<String> addPoint(String str) {
        List<String> res = new ArrayList<>();
        if (vaildCheck(str)) {
            res.add(str);
        }
        for (int i = 1; i < str.length(); i++) {
            String nstr = "";
            nstr = str.substring(0, i) + '.' + str.substring(i, str.length());
            if (vaildCheck(nstr)) {
                res.add(nstr);
            }
        }
        return res;
    }
    public List<String> ambiguousCoordinates(String S) {
        List<String> ans = new ArrayList<>();
        if (S == null || S.length() == 0)
            return ans;
        String str = new String(S);
        str = str.substring(1, str.length()-1);
        for (int i = 1; i < str.length(); i++) {
            List<String> list1 = addPoint(str.substring(0, i));
            List<String> list2 = addPoint(str.substring(i, str.length()));
            for (String s1 : list1) {
                for (String s2 : list2) {
                    String nsb = "";
                    nsb = '(' + s1 + ", " + s2 + ')';
                    ans.add(nsb);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(s.ambiguousCoordinates(str));
        }
    }
}