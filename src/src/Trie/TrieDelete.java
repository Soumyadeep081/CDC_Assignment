package Trie;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEndOfWord = false;
}

public class TrieDelete {

    private TrieNode root;

    public TrieDelete() {
        root = new TrieNode();
    }

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

    public void deleteWord(String word) {
        deleteHelper(root, word, 0);
    }

    private boolean deleteHelper(TrieNode node, String word, int index) {
        if (index == word.length()) {
            if (!node.isEndOfWord) return false;
            node.isEndOfWord = false;
            return isEmpty(node);
        }

        int idx = word.charAt(index) - 'a';
        TrieNode child = node.children[idx];
        if (child == null) return false;

        boolean shouldDeleteChild = deleteHelper(child, word, index + 1);

        if (shouldDeleteChild) {
            node.children[idx] = null;
            return !node.isEndOfWord && isEmpty(node);
        }
        return false;
    }

    private boolean isEmpty(TrieNode node) {
        for (TrieNode child : node.children) {
            if (child != null) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TrieDelete trie = new TrieDelete();

        trie.insert("hello");
        trie.insert("hell");
        trie.insert("world");
        trie.insert("trie");

        System.out.println("Before delete:");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hell"));

        trie.deleteWord("hello");

        System.out.println("\nAfter deleting 'hello':");
        System.out.println(trie.search("hello"));
        System.out.println(trie.search("hell"));
    }
}
