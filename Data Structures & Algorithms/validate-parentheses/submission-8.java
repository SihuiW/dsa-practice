class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stk.push(c);
            } else {
                if(!stk.isEmpty() && f(c) == stk.peek()) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
        }
        return stk.isEmpty();
    }

    char f(char c) {
        if(c == ')') return '(';
        if(c == ']') return '[';
        return '{';
    }
}
