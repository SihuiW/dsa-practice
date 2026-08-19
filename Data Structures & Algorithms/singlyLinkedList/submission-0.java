class Node {
    int val;
    Node prev;
    Node next;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LinkedList {

    Node head = new Node(-1);
    Node tail = new Node(-1);

    public LinkedList() {
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        Node p = head.next;
        for(int i = 0; i < index; i++) {
            if(p == tail) return -1;
            p = p.next;
        }
        return (p == tail) ? -1 : p.val;
    }

    public void insertHead(int val) {
        Node n = new Node(val);
        n.next = head.next;
        n.prev = head;
        head.next.prev = n;
        head.next = n;
    }

    public void insertTail(int val) {
        Node n = new Node(val);
        n.prev = tail.prev;
        n.next = tail;
        tail.prev.next = n;
        tail.prev = n;
    }

    public boolean remove(int index) {
        Node p = head.next;
        for(int i = 0; i < index; i++) {
            if(p == tail) return false;
            p = p.next;
        }
        if (p == tail) return false;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        Node p = head.next;
        while(p != tail) {
            res.add(p.val);
            p = p.next;
        }

        return res;
    }
}

