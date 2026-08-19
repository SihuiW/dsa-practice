class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        if(s.length() == 1) return false;
        for(char c: s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                stk.push(c);
            } else {
                int a = f(c);
                if(!stk.isEmpty() && stk.peek() == a) {
                    stk.pop();
                } else {
                    return false;
                }
            }
        }
        return stk.isEmpty();
    }

    private char f(char c) {
        if(c == '}') return '{';
        if(c == ']') return '[';
        return '(';
    }
}
