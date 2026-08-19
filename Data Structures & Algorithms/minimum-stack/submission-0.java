class MinStack {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public MinStack() {
        
    }
    
    public void push(int val) {
        stk1.push(val);
        if(!stk2.isEmpty()) {
            if(val < stk2.peek()) {
                stk2.push(val);
            } else {
                stk2.push(stk2.peek());
            }
        } else {
            stk2.push(val);
        }
    }
    
    public void pop() {
        stk1.pop();
        stk2.pop();
    }
    
    public int top() {
        return stk1.peek();
    }
    
    public int getMin() {
        return stk2.peek();
    }
}
