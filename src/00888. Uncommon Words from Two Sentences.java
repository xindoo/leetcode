import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> mapA = new HashMap<>();
        Map<String, Integer> mapB = new HashMap<>();
        for (String str : A.split(" ")) {
            int cnt = mapA.getOrDefault(str, 0);
            mapA.put(str, cnt+1);
        }
        for (String str : B.split(" ")) {
            int cnt = mapB.getOrDefault(str, 0);
            mapB.put(str, cnt+1);
        }
        List<String> ans = new ArrayList<>();
        for (String str : A.split(" ")) {
            int cntA = mapA.getOrDefault(str, 0);
            int cntB = mapB.getOrDefault(str, 0);
            if (cntA + cntB == 1) {
                ans.add(str);
            }
        }
        for (String str : B.split(" ")) {
            int cntA = mapA.getOrDefault(str, 0);
            int cntB = mapB.getOrDefault(str, 0);
            if (cntA + cntB == 1) {
                ans.add(str);
            }
        }
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}