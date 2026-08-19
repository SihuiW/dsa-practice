class SegmentTree {
    private Node root;
    class Node {
        int start;
        int end;
        int sum;

        Node left;
        Node right;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public SegmentTree(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }

    public Node build(int[] nums, int start, int end) {
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        int mid = start + (end - start) / 2;
        node.left = build(nums, start, mid);
        node.right = build(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    private void update(int index, int val) {
        up(root, index, val);
    }

    private void up(Node node, int index, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            up(node.left, index, val);
        } else {
            up(node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    public int query(int L, int R) {
        return f(root, L, R);
    }

    private int f(Node node, int L, int R) {
        if (node == null) {
            return 0;
        }

        if (node.end < L || node.start > R) {
            return 0;
        }

        if (L <= node.start && node.end <= R) {
            return node.sum;
        }

        return f(node.left, L, R) + f(node.right, L, R);
    }
}
