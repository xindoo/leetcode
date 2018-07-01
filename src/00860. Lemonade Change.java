class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] cnt = new int[3];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                cnt[0]++;
            } else if (bills[i] == 10) {
                cnt[1]++;
                if (cnt[0] == 0){
                    return false;
                } else {
                    cnt[0]--;
                }
            } else {
                cnt[2]++;
                int num = 15;
                if (cnt[1] > 0) {
                    num -= 10;
                    cnt[1]--;
                }
                while (cnt[0] > 0 && num > 0) {
                    num -= 5;
                    cnt[0]--;
                }
                if (num != 0)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lemonadeChange(new int[]{5,5,10,10,20}));
    }
}