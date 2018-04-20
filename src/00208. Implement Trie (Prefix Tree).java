class Trie {
    private Trie[] children = null;
    public boolean isWord = false;
    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (null == word || word.length() == 0 ) {
            return ;
        }

        if (null == children[word.charAt(0) - 'a'] ) {
            children[word.charAt(0) - 'a'] = new Trie();
        }
        if (word.length() == 1) {
            children[word.charAt(0) - 'a'].isWord = true;
        }
        children[word.charAt(0) - 'a'].insert(word.substring(1));

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word.length() == 0)
            return true;
        if (word.length() == 1 && children[word.charAt(0) - 'a'] != null) {
            return children[word.charAt(0) - 'a'].isWord;
        }
        if (null != this.children[word.charAt(0)-'a']) {
            return this.children[word.charAt(0)-'a'].search(word.substring(1));
        }
        return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0) {
            return true;
        }
        if (null != this.children[prefix.charAt(0)-'a']) {
            return this.children[prefix.charAt(0)-'a'].startsWith(prefix.substring(1));
        }
        return false;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */