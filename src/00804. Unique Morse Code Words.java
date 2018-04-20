import java.util.HashMap;

class Solution {
    private String[] strs = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        for (String word: words) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < word.length(); i++) {
                sb.append(strs[word.charAt(i)-'a']);
            }
            map.put(sb.toString(), 1);
        }
        return map.size();
    }
}