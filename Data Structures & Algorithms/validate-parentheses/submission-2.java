class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '[' || c == '{' || c == '(') {
                stk.push(c);
            } else if (c == '}' || c == ']' || c == ')') {
                char d = reverse(c);
                if(!stk.isEmpty() && d == stk.peek()) {
                    stk.pop();
                } else {
                    return false;
                }
            } 
        }
        return stk.isEmpty() ? true: false;
    }

    private char reverse(char c) {
        if(c ==']') {
            return '[';
        } else if(c == '}') {
            return '{';
        } 
        return '(';
    }
}
