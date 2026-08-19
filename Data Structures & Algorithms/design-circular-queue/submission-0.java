class MyCircularQueue {
    int size;
    int[] q;
    int l = 0, r = 0;
    // - - - - -
    // 1 2 3 4 5
    // l  
    //         r

    public MyCircularQueue(int k) {
        size = 0;
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if(!isFull()) {
            q[r] = value;
            size++;
            r = (r + 1) % q.length;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        size--;
        l = (l + 1) % q.length;
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return q[l];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return q[(r - 1 + q.length) % q.length];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */