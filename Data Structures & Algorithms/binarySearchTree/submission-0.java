class TreeMap {
    Node root = null;

    public TreeMap() {
        
    }

    public void insert(int key, int val) {
        Node node = new Node(key, val);
        if(root == null) {
            root = node;
            return;
        }

        Node p = root;
        while(true) {
            if(key < p.key) {
                if(p.left == null) {
                    p.left = node;
                    return;
                }
                p = p.left;
            } else if (key > p.key) {
                if(p.right == null) {
                    p.right = node;
                    return;
                }
                p = p.right;
            } else {
                p.val = val;
                return;
            }
        }

    }

    public int get(int key) {
        Node p = root;
        while(p != null) {
            if(p.key == key) {
                return p.val;
            } else if(p.key < key) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        return -1;
    }

    public int getMin() {
        if (root == null) return -1;
        Node p = root;
        while(p.left != null) {
            p = p.left;
        }
        return p.val;
    }

    Node findMin(Node node) {
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    public int getMax() {
        if (root == null) return -1;
        Node p = root;
        while(p.right != null) {
            p = p.right;
        }
        return p.val;
    }

    public void remove(int key) {
       root = f(root, key);
    }

    Node f(Node p, int key) {
        if(p == null) return null;
        if(key > p.key) {
            p.right = f(p.right, key);
        } else if(key < p.key) {
            p.left = f(p.left, key);
        } else {
            if(p.left == null) {
                return p.right;
            } else if (p.right == null) {
                return p.left;
            } else {
                Node min = findMin(p.right);
                p.key = min.key;
                p.val = min.val;
                p.right = f(p.right, min.key); 
            }
        }
        return p;
    }

    public List<Integer> getInorderKeys() {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;
    }

    void dfs(Node root, List<Integer> list) {
        if(root == null) return;
        dfs(root.left, list);
        list.add(root.key);
        dfs(root.right, list);
    }
}


class Node {
    int val;
    int key;
    Node left;
    Node right;

    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
