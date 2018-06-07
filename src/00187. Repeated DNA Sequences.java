class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        for (int i = 0; i < s.length() -9; i++) {
            String substr = s.substring(i, i+10);
            if (set.contains(substr)) {
                res.add(substr);
            }
            set.add(substr);
        }

        return new ArrayList(res);
    }
}