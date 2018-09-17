import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 用一个map把其中一个list的每个string的index存下来,遍历另一个list的时候就可以快速计算出同一个str的index之后 
 * 如果遇到比min更小的, 就更新下, 这里题目要求是最小的所有字符, 所有我们我们需要在整个过程中保存下所有可能的中间
 * 结果. 
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list2 == null)
            return null;
        List<String> res = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);

        }
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int tmp = map.get(list2[i]) + i;
                if (tmp < min) {
                    res.clear();
                    res.add(list2[i]);
                    min = tmp;

                } else if (tmp == min) {
                    res.add(list2[i]);
                }
            }
        }
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}