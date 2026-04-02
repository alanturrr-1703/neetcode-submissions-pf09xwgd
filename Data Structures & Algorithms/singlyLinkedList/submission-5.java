class Node {
    int val;
    Node next;

    Node (int val){
        this(val, null);
    }
    Node (int val, Node next){
        this.val = val;
        this.next = next;
    }
}
class LinkedList {
    Node head;
    Node tail;

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        Node curr = this.head.next;
        int i = 0;
        while (curr != null){
            if (index == i){
                return curr.val;
            }
            i++;
            curr = curr.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        node.next = this.head.next;
        this.head.next = node;
        if(node.next == null){
            tail = node;
        }
    }

    public void insertTail(int val) {
        this.tail.next = new Node(val);
        this.tail = this.tail.next;
    }

    public boolean remove(int index) {
        int i = 0;
        Node curr = this.head;
        while (i <  index && curr != null){
            i++;
            curr = curr.next;
        }
        if(curr != null && curr.next != null){
            if(curr.next == this.tail){
                this.tail = curr;
            }
            curr.next = curr.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        Node curr = this.head.next;
        ArrayList<Integer> res = new ArrayList<>();
        while (curr != null) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}
