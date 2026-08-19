class Deque {

    Node head;
    Node tail;

    public Deque() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }

    public void append(int value) {
       Node node = new Node(value);
       node.next = tail;
       node.prev = tail.prev;
       tail.prev.next = node;
       tail.prev = node;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public int pop() {
        if(head.next == tail) return -1;
        int v = tail.prev.val;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return v;
    }

    public int popleft() {
        if(head.next == tail) return -1;
        int v = head.next.val;
        head.next.next.prev = head;
        head.next = head.next.next;
        return v;
    }
}

class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}
