import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] tree) {
        if (tree.length  <= 2) {
            return tree.length;
        }
        int maxV = 0;
        Map<Integer, Integer> basket = new HashMap<>();
        int cntType = 0;
        int i = 0;
        int j = 0;

        while (j < tree.length && i < tree.length) {
            if (cntType > 2){
                int val = basket.getOrDefault(tree[i], 0);
                if (val == 1) {
                    cntType--;
                }
                basket.put(tree[i], val-1);
                i += 1;
            } else {
                int val = basket.getOrDefault(tree[j], 0);
                if (val == 0) {
                    cntType++;
                }
                basket.put(tree[j], basket.getOrDefault(tree[j], 0)+1);
                if (cntType <= 2) {
                    maxV = Math.max(maxV, (j-i)+1);
                }
                j += 1;
            }
        }

        return maxV;
    }
}