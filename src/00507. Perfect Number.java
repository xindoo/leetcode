class Solution {
    public boolean checkPerfectNumber(int num) {
        if (1 == num)
            return false;
        int sum = 0;
        for (int i = 2; i*i <= num; i++) {
            if (num%i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        sum++;
        return sum == num;
    }
}