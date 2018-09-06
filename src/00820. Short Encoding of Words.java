class Solution {
    private int cnt = 0;
    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        cnt = 0;
        for(String word: words) {
            root.addWord(word);
        }
        return cnt;
    }

    class Trie {
        public Trie[] next;
        public String word;

        public Trie () {
            this.next = new Trie[26];
            this.word = null;
        }

        public void addWord(String w) {
            Trie curr = this;
            for(int i = w.length() - 1; i >= 0; i--) {
                if(curr.next[w.charAt(i)-'a'] == null) {
                    curr.next[w.charAt(i)-'a'] = new Trie();
                }
                curr = curr.next[w.charAt(i)-'a'];
                if(curr.word != null) {
                    cnt -= curr.word.length() + 1;
                    curr.word = null;
                }
            }
            for(int i = 0; i < 26; i++) {
                if(curr.next[i] != null) {
                    return;
                }
            }
            curr.word = w;
            cnt += w.length() + 1;
        }
    }
}

