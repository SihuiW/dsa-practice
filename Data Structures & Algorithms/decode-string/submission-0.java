class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> stk1 = new Stack<>();
        Stack<Integer> stk2 = new Stack<>();
        int k = 0;
        StringBuilder sb = new StringBuilder();

        for(Character c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stk2.push(k);
                k = 0;
                stk1.push(sb);
                sb = new StringBuilder();
            } else if (c == ']') {
                int count = stk2.pop();
                StringBuilder temp = new StringBuilder();
                while(count > 0) {
                    temp.append(sb);
                    count--;
                }
                sb = stk1.pop().append(temp.toString());
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}