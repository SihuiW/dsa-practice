class MyStack {

    Queue<Integer> q = new LinkedList<>();


    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        int k = q.size() - 1;
        while(k > 0) {
            int pre = q.poll();
            q.add(pre);
            k--;
        }

    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */