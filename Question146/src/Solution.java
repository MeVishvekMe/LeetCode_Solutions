import java.util.HashMap;

class LRUCache {

    int capacity; // Maximum capacity of the cache
    HashMap<Integer, Node> cache; // HashMap to store key-value pairs for quick lookup
    Node left; // Dummy node representing the least recently used (LRU) end
    Node right; // Dummy node representing the most recently used (MRU) end

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(-1, -1); // Left dummy node (LRU end)
        this.right = new Node(-1, -1); // Right dummy node (MRU end)
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    // Remove a node from the doubly linked list
    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Insert a node at the right (MRU position) in the doubly linked list
    private void insert(Node node) {
        Node prevNode = this.right.prev; // Get the current last node before 'right'
        node.next = this.right;
        node.prev = prevNode;
        prevNode.next = node;
        this.right.prev = node;
    }

    // Get the value of the key if it exists in the cache
    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node); // Remove node from current position
            insert(node); // Insert it at MRU position
            return node.value;
        }
        return -1; // Key not found in cache
    }

    // Put a key-value pair in the cache
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            remove(cache.get(key)); // Remove the existing node
        }

        Node newNode = new Node(key, value);
        cache.put(key, newNode); // Store node in HashMap
        insert(newNode); // Insert it at MRU position

        // If the cache exceeds capacity, remove the least recently used (LRU) node
        if(cache.size() > capacity) {
            Node lru = this.left.next; // Get the least recently used node
            remove(lru); // Remove it from the list
            cache.remove(lru.key); // Remove it from the HashMap
        }
    }
}

// Node class representing a doubly linked list node
class Node {
    int key;
    int value;
    Node next;
    Node prev;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
