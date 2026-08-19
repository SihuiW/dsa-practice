class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        String operation = "+-*/";
        for(String s: tokens) {
            if(!operation.contains(s)) {
                stk.push(Integer.parseInt(s));
            } else {
                int b = stk.pop();
                int a = stk.pop();
                if(s.equals("+")) {
                    stk.push(a + b);
                } else if(s.equals("-")) {
                    stk.push(a - b);
                } else if(s.equals("*")) {
                    stk.push(a * b);
                } else {
                    stk.push(a / b);
                }
            }
        }
        return stk.peek();
    }   
}