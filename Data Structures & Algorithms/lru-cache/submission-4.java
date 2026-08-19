class LRUCache {
    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap<>();
    int cap = 0;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        moveLast(node);
        return node.val;
    }

    private void moveLast(Node node) {
        if (node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        node.prev = tail.prev;
        tail.prev.next = node;
        node.next = tail;
        tail.prev = node;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            check();
            Node node = new Node(key, value);
            map.put(key, node);
            moveLast(node);
        } else {
            Node old = map.get(key);
            old.val = value;
            moveLast(old);
        }
    }

    private void check() {
        if (map.size() < cap)
            return;
        Node node = head.next;
        head.next = head.next.next;
        head.next.prev = head;
        map.remove(node.key);
    }
}
