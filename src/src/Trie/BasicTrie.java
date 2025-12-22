package Trie;

public class BasicTrie {

    private TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        BasicTrie trie = new BasicTrie();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("trie");

        System.out.println(trie.search("hello"));
        System.out.println(trie.search("world"));
        System.out.println(trie.search("trie"));
        System.out.println(trie.search("test"));
    }
}
