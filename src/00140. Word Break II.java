import java.util.ArrayList;
import java.util.List;

class Solution {
    private int[] dp = null;
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (null == dp) {
            dp = new int[s.length()+1];
            dp[0] = 1;
        }
        List<String> list = new ArrayList<String>();
        int len = s.length();
        for (int i = len-1; i >= 0; i--) {
            if (wordDict.contains(s.substring(i,len))) {
                if (0 == i) {
                    list.add(s);
                    dp[s.length()-1] = 1;
                }
                else {
                    List<String> sublist = null;
                    if (0 == dp[i-1] || 1 == dp[i-1]) {
                        sublist = wordBreak(s.substring(0, i), wordDict);
                        dp[i - 1] = -1;
                        for (int j = 0; j < sublist.size(); j++) {
                            dp[i - 1] = 1;
                            list.add(sublist.get(j) + " " + s.substring(i, len));
                        }
                    }
                }
            }
        }
        return list;
    }
}