
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        if (nums.length < 2) {
            if (nums.length == 0)
                return ret;
            ret.add(nums[0]);
            return ret;
        }
        Arrays.sort(nums);
        int[] prenodes = new int[nums.length];
        int[] factorcount = new int[nums.length];
        int maxlength = 0;
        int maxnum = 0;
        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j]%nums[i] == 0 && factorcount[i] < factorcount[j]+1) {
                    factorcount[i] = factorcount[j]+1;
                    prenodes[i] = j;
                    if (factorcount[i] > maxlength) {
                        maxlength = factorcount[i];
                        maxnum = i;
                    }
                }
            }
        }
        
        for (int i = 0; i < maxlength; i++) {
            ret.add(nums[maxnum]);
            maxnum = prenodes[maxnum];
        }
        return ret;
    }
}