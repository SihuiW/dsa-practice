class Solution {
    public int maxDepth(String s) {
        int res = 0;
        int cnt = 0;
        Stack<Integer> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(c == '(') {
                cnt++;
                res = Math.max(cnt, res);
            } else if(c== ')') {
                cnt--;
            }
        }
        return res;
    }
}