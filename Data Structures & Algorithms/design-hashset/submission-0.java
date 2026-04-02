class Node {
    int key;
    Node next;

    Node(int key) {
        this.key = key;
    }
}

class MyHashSet {

    private Node[] buckets;
    private int size = 1000;

    public MyHashSet() {
        buckets = new Node[size];
    }

    private int hash(int key) {
        return key % size;
    }

    public void add(int key) {
        int h = hash(key);
        Node head = buckets[h];

        Node curr = head;
        while (curr != null) {
            if (curr.key == key) return; // already exists
            curr = curr.next;
        }

        Node node = new Node(key);
        node.next = head;
        buckets[h] = node;
    }

    public void remove(int key) {
        int h = hash(key);
        Node curr = buckets[h];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    buckets[h] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        Node curr = buckets[h];

        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }

        return false;
    }
}