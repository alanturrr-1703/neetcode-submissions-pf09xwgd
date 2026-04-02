public class Node {
    Node next;
    Node prev;
    int key;
    int value;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.prev = null;
        this.right.prev = this.left;
        this.right.next = null;
        this.left.next = this.right;
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insertNode(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            removeNode(node);
            insertNode(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            removeNode(cache.get(key));
        }
        Node node = new Node(key, value);
        cache.put(key, node);
        insertNode(node);
        if (cache.size() > capacity) {
            Node lru = this.left.next;
            cache.remove(lru.key);
            removeNode(lru);
        }
    }
}