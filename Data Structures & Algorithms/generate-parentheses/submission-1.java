class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(0, 0, n, sb, res);
        return res;
    }

    void f(int left, int right, int n, StringBuilder sb, List<String> res) {
        if(left == n && left == right) {
            res.add(sb.toString());
            return;
        }
        if(left > n || right > left) return;

        if(left < n) {
            sb.append("(");
            f(left + 1, right, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left) {
            sb.append(")");
            f(left, right + 1, n, sb, res);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
}
