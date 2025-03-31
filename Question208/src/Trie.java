class Trie {

    // Definition for a Trie node
    class TrieNode {
        TrieNode[] nodes = new TrieNode[26]; // Array to store references to child nodes (for 'a' to 'z')
        boolean isEndOfWord = false; // Flag to mark the end of a word
    }

    TrieNode trieNode; // Root node of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        trieNode = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode current = trieNode; // Start from the root node
        for(char c: word.toCharArray()) { // Iterate over each character in the word
            int index = c - 'a'; // Compute the index of the character (0-25)
            if(current.nodes[index] == null) { // If the corresponding child node does not exist, create it
                current.nodes[index] = new TrieNode();
            }
            current = current.nodes[index]; // Move to the next node
        }
        current.isEndOfWord = true; // Mark the end of the word
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = traverseTrie(word); // Traverse the Trie for the given word
        return node != null && node.isEndOfWord; // Return true if found and is a complete word
    }

    // Method to check if a prefix exists in the Trie
    public boolean startsWith(String prefix) {
        return traverseTrie(prefix) != null; // Return true if the prefix exists
    }

    // Helper method to traverse the Trie for a given string (word or prefix)
    private TrieNode traverseTrie(String s) {
        TrieNode current = trieNode; // Start from the root node
        for(char c: s.toCharArray()) { // Iterate over each character in the string
            int index = c - 'a'; // Compute the index of the character (0-25)
            if(current.nodes[index] == null) { // If the path does not exist, return null
                return null;
            }
            current = current.nodes[index]; // Move to the next node
        }
        return current; // Return the last node reached
    }
}
