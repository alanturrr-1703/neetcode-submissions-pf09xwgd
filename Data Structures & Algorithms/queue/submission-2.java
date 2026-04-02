public class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class Deque {
    Node head;
    Node tail;
    int length;
    public Deque() {
        this.head = new Node(-1);
        this.tail = this.head;
        this.length = 0;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void append(int value) {
        this.tail.next = new Node(value);
        this.tail.next.prev = this.tail;
        this.tail = this.tail.next;
        this.length++;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        if (this.length == 0) {
            append(value);
        } else {
            node.next = this.head.next;
            this.head.next.prev = node;
            node.prev = this.head;
            this.head.next = node;
            this.length++;
        }
    }

    public int pop() {
        if (this.tail != this.head) {
            int ans = this.tail.val;
            this.tail = this.tail.prev;
            this.tail.next = null;
            this.length--;
            return ans;
        }
        return -1;
    }

    public int popleft() {
        if (this.head.next != null) {
            int val = this.head.next.val;
            if (this.head.next == this.tail) {
                this.head.next = null;
                this.tail = this.head;
                this.length--;
                return val;
            }
            this.head.next = this.head.next.next;
            this.head.next.prev = this.head;
            this.length--;
            return val;
        }
        return -1;
    }
}
