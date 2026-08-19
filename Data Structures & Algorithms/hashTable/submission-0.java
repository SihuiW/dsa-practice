class Node {
    int key;
    int val;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.next = null;
    }
}

class HashTable {

    int cap;
    int size;
    Node[] table;


    public HashTable(int capacity) {
        this.cap = capacity;
        this.size = 0;
        table = new Node[this.cap];
    }

    int hashFunction(int key) {
        return key % this.cap;
    }

    public void insert(int key, int value) {
        int idx = hashFunction(key);
        Node node = table[idx];
        if(node == null) {
            table[idx] = new Node(key, value);
            size++;
        } else {
            
            Node prev = null;
            while(node != null) {
                if(node.key == key) {
                    node.val = value;
                    return;
                }
                prev = node;
                node = node.next;
            }
            prev.next = new Node(key,value);
            size++;

        }
        if((double)size / cap >= 0.5) resize();
    }

    public int get(int key) {
        int idx = hashFunction(key);
        Node node = table[idx];
        while(node != null) {
            if(node.key == key) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int idx = hashFunction(key);
        Node node = table[idx];
        Node prev = null;

        while(node != null) {
            if(node.key == key) {
                if(prev != null) {
                    prev.next = node.next;
                } else {
                    table[idx] = node.next;
                }
                size--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.cap;
    }

    public void resize() {
        int newCap = this.cap * 2;
        Node[] newTable = new Node[newCap];
        for(Node node: table) {
            while(node != null) {
                int idx = node.key % newCap;
                if(newTable[idx] == null) {
                    newTable[idx] = new Node(node.key, node.val);
                } else {
                    Node newNode = newTable[idx];
                    while(newNode.next != null) {
                        newNode = newNode.next;
                    }
                    newNode.next = new Node(node.key, node.val);
                }
                node = node.next;
            }
        }
        this.cap = newCap;
        this.table = newTable;
    }
}
