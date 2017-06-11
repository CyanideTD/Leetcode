public class Trie {
    class Node {
    	boolean isWord;
	Node[] next;
	public Node() {
		isWord = false;
		next = new Node[26];
	}
    }
    Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] string = word.toCharArray();
	Node cur = root;
	for (int i = 0; i < string.length; i++) {
		if (cur.next[string[i] - 'a'] == null) {
			cur.next[string[i] - 'a'] = new Node();
			cur = cur.next[string[i] - 'a'];
		} else {
			cur = cur.next[string[i] - 'a'];
		}
	}
	cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] string = word.toCharArray();
	Node cur = root;
	for (int i = 0; i < string.length; i++) {
		if (cur.next[string[i] - 'a'] == null) {
			return false;
		} else {
			cur = cur.next[string[i] - 'a'];
		}
	}
	return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] pre = prefix.toCharArray();
	Node cur = root;
	for (int i = 0; i < pre.length; i++) {
		if (cur.next[pre[i] - 'a'] == null) {
			return false;
		}
		cur = cur.next[pre[i] - 'a'];
	}
	return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
