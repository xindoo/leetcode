public class Solution {
    private int powmod(int a, int b, int mod) {
        int ans = 1;
        for (int i = 0; i < b; i++) {
            ans = (ans*a)%mod;
        }
        return ans;
    }
    public int superPow(int a, int[] b) {
        int ans = 1;
        a %= 1337;
        for (int i = 0; i < b.length; i++) {
            ans = (powmod(ans,10,1337)*powmod(a, b[i], 1337)) % 1337;
        }
        return ans;
    }
    public static void main(String args[]) {
        Solution s = new Solution();
        int a = 121;
        int[] b = {14,4,2,582,2,2,3,6};
        int ans = s.superPow(a, b);
        System.out.println(ans);
    }
}