import java.util.Scanner;

class Solution {
    public String solveEquation(String equation) {
        int cntCoeff = 0;
        int cntConstant = 0;
        equation += "+";
        int factor = 1;
        int s = 0, e = 1;
        while (e < equation.length()) {
            if (equation.charAt(e) == '+' || equation.charAt(e) == '-' || equation.charAt(e) == '=') {
                if (equation.charAt(s) == '=') {
                    factor = -1;
                    s++;
                }
                String str = null;
                if (equation.charAt(e-1) == 'x') {
                    str = equation.substring(s, e-1);
                    if ("+".equals(str)|| "-".equals(str) || "".equals(str))
                        str += "1";
                    cntCoeff += factor*Integer.parseInt(str);
                } else {
                    str = equation.substring(s, e);
                    if ("+".equals(str)|| "-".equals(str) || "".equals(str))
                        str += "1";
                    cntConstant += -1*factor*Integer.parseInt(str);
                }
                s = e++;
            }
            e++;
        }
        if (cntCoeff == 0) {
            if (cntConstant == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }
        return "x="+cntConstant/cntCoeff;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Solution s = new Solution();
        while (in.hasNext()) {
            String str = in.next();
            System.out.println(s.solveEquation(str));
        }
    }
}