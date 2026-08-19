class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        for(String s: operations) {
            if (s.equals("+")) {
                int a2 = stk.pop();
                int a1 = stk.peek();
                stk.push(a2);
                stk.push(a1 + a2);
            } else if (s.equals("C")) {
                stk.pop();
            } else if (s.equals("D")){
                int a = stk.peek() * 2;
                stk.push(a);
            } else {
                stk.push(Integer.parseInt(s));
            }
        }
        int res = 0;
        while(!stk.isEmpty()) {
            res += stk.pop();
        }
        return res;
    }
}