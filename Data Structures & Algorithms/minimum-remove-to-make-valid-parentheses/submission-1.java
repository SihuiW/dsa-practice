class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stk = new Stack<>();
        int left = 0;

        for(char c: s.toCharArray()) {
            if(c == '(') {
                stk.push(c);
                left++;
            } else if(c == ')') {
                if(left > 0) {
                    stk.push(c);
                    left--;
                }
            } else {
                stk.push(c);
            }
        }

        while(!stk.isEmpty()) {
            char current = stk.pop();
            if(left > 0 && current == '(') {
                left--;
            } else {
                sb.append(current);
            }
        }

        return sb.reverse().toString();


    }
}