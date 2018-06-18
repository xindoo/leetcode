import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        combinationSum(k, n, 1, new ArrayList<>(), res);
        return res;
    }

    private void combinationSum(int k, int n, int start, List<Integer> sublist, List<List<Integer>> res) {
        if (k < 0 || n < 0)
            return;

        if (k == 0) {
            if (n != 0)
                return;
            res.add(new ArrayList<>(sublist));
            return;
        }

        for (int i = start; i <= 9; i++) {
            sublist.add(i);
            combinationSum(k - 1, n - i, i + 1, sublist, res);
            sublist.remove(sublist.size() - 1);
        }
    }
}