class LFUCache {
    int cap;
    int size;
    int minFreq;

    Map<Integer, Node> kn;
    Map<Integer, DoubleList> fl;
    
    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        public Node (int key, int value) {
            this.key = key;
            this.value = value;
            freq = 1;
            prev = null;
            next = null;
        }
    }

    class DoubleList {
        Node head = new Node(0,0);
        Node tail = new Node(0,0);
        int size;

        public DoubleList () {
            head.next = tail;
            tail.prev = head;
            this.size = 0;
        }

        public void add(Node node) {
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
            size--;
        }
    }

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.size = 0;
        this.minFreq = 0;
        kn = new HashMap<>();
        fl = new HashMap<>();
    }
    
    public int get(int key) {
        if(kn.containsKey(key)) {
            Node node = kn.get(key);
            int oldFreq = node.freq;
            node.freq++;
            DoubleList list = fl.get(oldFreq);
            list.remove(node);
            if(list.size == 0 && oldFreq == minFreq) {
                minFreq++;
            }
            if(fl.containsKey(oldFreq + 1)) {
                fl.get(oldFreq + 1).add(node);
            } else {
                DoubleList temp = new DoubleList();
                temp.add(node);
                fl.put(oldFreq + 1, temp);
            }
            return node.value;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if(kn.containsKey(key)) {
            Node node = kn.get(key);
            node.value = value;
            int preFreq = node.freq;
            node.freq++;
            DoubleList list = fl.get(preFreq);
            list.remove(node);
            if(preFreq == minFreq && list.size == 0) {
                minFreq++;
            }
            if(fl.containsKey(preFreq + 1)) {
                fl.get(preFreq + 1).add(node);
            } else {
                DoubleList temp = new DoubleList();
                temp.add(node);
                fl.put(preFreq + 1, temp);
            }
        } else {
            Node newNode = new Node(key, value);
            if(size == cap) {
                DoubleList list = fl.get(minFreq);
                Node delNode = list.head.next;
                list.remove(delNode);
                size--;
                kn.remove(delNode.key);
            }
            kn.put(key, newNode);
            if(fl.containsKey(1)) {
                fl.get(1).add(newNode);
            } else {
                DoubleList temp = new DoubleList();
                temp.add(newNode);
                fl.put(1, temp);
            }
            size++;
            minFreq = 1;

        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */