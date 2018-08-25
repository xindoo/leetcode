import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        if (null == arr || arr.length == 0) {
            return 0;
        }
        int[] narr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(narr);
        Map<Integer, LinkedList<Integer>> map = new HashMap();
        for (int i = 0; i < narr.length; i++) {
            LinkedList<Integer> list = map.getOrDefault(narr[i], new LinkedList<Integer>());
            list.add(i);
            if (list.size() == 1) {
                map.put(narr[i], list);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> list = map.get(arr[i]);
            arr[i] = list.get(0);
            list.removeFirst();
        }
        int cnt = 0;
        int maxP = 0;
        for (int i = 0; i < arr.length; i++) {
            maxP = Math.max(maxP, arr[i]);
            if (maxP == i) {
                cnt++;
            }
        }
        return cnt;
    }
}