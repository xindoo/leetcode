import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int cnt = 1;
        for (int i = 1; ; i++) {
            if (i == S.length()) {
                if (cnt >= 3) {
                    List<Integer> subList = new ArrayList();
                    subList.add(i - cnt);
                    subList.add(i - 1);
                    res.add(subList);
                }
                break;
            }
            if (S.charAt(i) == S.charAt(i - 1)) {
                cnt++;
            } else {
                if (cnt >= 3) {
                    List<Integer> subList = new ArrayList();
                    subList.add(i - cnt);
                    subList.add(i - 1);
                    res.add(subList);
                }
                cnt = 1;
            }
        }
        return res;
    }
}
