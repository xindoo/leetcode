import java.math.BigInteger;

class Solution {
    public String addStrings(String num1, String num2) {
        BigInteger ba = new BigInteger(num1);
        BigInteger bb = new BigInteger(num2);
        return ba.add(bb).toString();
    }
}