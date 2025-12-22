package HuffmanCoding;

import java.util.*;

// Huffman Node
class HuffmanNode {
    char data;
    int freq;
    HuffmanNode left, right;

    HuffmanNode(char data, int freq) {
        this.data = data;
        this.freq = freq;
        this.left = null;
        this.right = null;
    }
}

// Comparator for Min-Heap (PriorityQueue)
class HuffmanComparator implements Comparator<HuffmanNode> {
    @Override
    public int compare(HuffmanNode a, HuffmanNode b) {
        return a.freq - b.freq;
    }
}

public class HuffmanCoding {

    // Build frequency map
    private static Map<Character, Integer> buildFreqMap(String text) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        return freq;
    }

    // Build Huffman Tree
    private static HuffmanNode buildHuffmanTree(Map<Character, Integer> freq) {
        PriorityQueue<HuffmanNode> pq =
                new PriorityQueue<>(new HuffmanComparator());

        // Create leaf nodes
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // Build tree
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            HuffmanNode internal =
                    new HuffmanNode('\0', left.freq + right.freq);
            internal.left = left;
            internal.right = right;

            pq.add(internal);
        }

        return pq.poll();
    }

    // Generate Huffman Codes
    private static void generateCodes(
            HuffmanNode root,
            String code,
            Map<Character, String> codes
    ) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            codes.put(root.data, code);
            return;
        }

        generateCodes(root.left, code + "0", codes);
        generateCodes(root.right, code + "1", codes);
    }

    // Encode string
    private static String encode(String text, Map<Character, String> codes) {
        StringBuilder encoded = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encoded.append(codes.get(ch));
        }
        return encoded.toString();
    }

    // Decode string
    private static String decode(String encoded, HuffmanNode root) {
        StringBuilder decoded = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encoded.toCharArray()) {
            if (bit == '0') current = current.left;
            else current = current.right;

            if (current.left == null && current.right == null) {
                decoded.append(current.data);
                current = root;
            }
        }
        return decoded.toString();
    }

    public static void main(String[] args) {
        String text = "huffman coding is fun";

        // Frequency map
        Map<Character, Integer> freq = buildFreqMap(text);

        // Huffman Tree
        HuffmanNode root = buildHuffmanTree(freq);

        // Generate codes
        Map<Character, String> codes = new HashMap<>();
        generateCodes(root, "", codes);

        // Print codes
        System.out.println("Huffman Codes:");
        for (Map.Entry<Character, String> e : codes.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }

        // Encode
        String encoded = encode(text, codes);
        System.out.println("\nOriginal text: " + text);
        System.out.println("Encoded text: " + encoded);

        // Decode
        String decoded = decode(encoded, root);
        System.out.println("Decoded text: " + decoded);

        if (text.equals(decoded)) {
            System.out.println("\nEncoding and decoding successful!");
        } else {
            System.out.println("\nError in encoding/decoding!");
        }
    }
}

