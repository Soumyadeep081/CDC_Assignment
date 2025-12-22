package Trie;



public class TrieCountWords {


    private TrieNode root;

    public TrieCountWords() {
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

    public int countWords() {
        return countHelper(root);
    }

    private int countHelper(TrieNode node) {
        if (node == null) return 0;

        int count = node.isEndOfWord ? 1 : 0;
        for (int i = 0; i < 26; i++) {
            count += countHelper(node.children[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        TrieCountWords trie = new TrieCountWords();
        trie.insert("hello");
        trie.insert("world");
        trie.insert("trie");
        trie.insert("hell");
        trie.insert("help");

        System.out.println("Total words in trie: " + trie.countWords());
        System.out.println("Search 'hello': " + trie.search("hello"));
        System.out.println("Search 'help': " + trie.search("help"));
    }
}
