public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int num:nums) {
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        if (o1.getValue() == o2.getValue())
                            return o1.getKey() - o2.getKey();
                        return o2.getValue() - o1.getValue();
                    }
                }
        );
        int cnt = 0;
        for (Map.Entry<Integer,Integer> entry:list) {
            ans.add(entry.getKey());
            cnt++;
            if (cnt == k)
                break;
        }
        return ans;
    }
}