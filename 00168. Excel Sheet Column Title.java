class Solution {
    public String convertToTitle(int n) {
        char[] arr={'Z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y'};
        StringBuffer sb = new StringBuffer();
        while (n > 0) {
            int i=n%26;
            sb.append(arr[i]);
            if(i==0) n = n-1;
            n/=26;
        }
        return new String(sb.reverse());
    }
}