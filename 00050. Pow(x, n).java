public class Solution {
    public double myPow(double x, int n) {
        if (0 == n)
            return 1;
        if (-2147483648 == n) {
            double tmp = myPow(x, n/2);
            return tmp*tmp;
        }
        if (n < 0)
            return 1.0/myPow(x, -n);
        double midrslt = myPow(x, n/2);
        double rlst = midrslt * midrslt;
        if (1 == n%2)
            rlst*=x;
        return rlst;
    }
    public static void main(String[] args) {
        System.out.println(-3%2);
    }
}