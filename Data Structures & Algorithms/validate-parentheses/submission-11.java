class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                stk.push(c);
            } else {
                char d = f(c);
                if(!stk.isEmpty() && d == stk.peek()) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    char f(char c) {
        if( c == ']') return '[';
        if(c == ')') return '(';
        return '{';
    } 
}
