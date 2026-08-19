class Solution {
    public boolean checkValidString(String s) {
        // 建一个栈记录左括号和index
        // 建一个栈记录星号和index
        // 指针指向s0位置，左括号入栈1，星号入栈2
        // 出现右括号 如果栈空 false 否则弹出左括号
        // 到最后 如果栈里有左括号，和星号位置进行比较，星号位置晚于它，就同时弹出，否则就false
        // 最后看第一个栈是否为空 空就是true

        Stack<Integer> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        int p = 0;
        while(p < s.length()) {
            char c = s.charAt(p);
            if(c == '(') {
                stk1.push(p);
            } else if(c == '*') {
                stk2.push(p);
            } else {
                if(!stk1.isEmpty()) {
                    stk1.pop();
                } else if(!stk2.isEmpty()) {
                    stk2.pop();
                } else {
                    return false;
                }
            }
            p++;

        }

        while(!stk1.isEmpty() && !stk2.isEmpty()) {
            if(stk1.peek() < stk2.peek()) {
                stk1.pop();
                stk2.pop();
            } else {
                return false;
            }
        }
        return stk1.isEmpty();
    }
}

