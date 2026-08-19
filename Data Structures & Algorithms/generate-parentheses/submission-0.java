class Solution {
    // 两种情况
    // 1. (小于n时，可以加入(
    // 2. )的数量小于)，可以加入)
    // 如果(的数量等于n并且)的数量等于(，记录组合
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        f(0,0,n,sb);
        return res;
    }

    List<String> res = new ArrayList<>();

    void f(int left, int right, int n, StringBuilder sb) {
        if(left == n && left == right) {
            res.add(sb.toString());
            return;
        }

        if(left < n) {
            sb.append("(");
            f(left + 1, right, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left) {
            sb.append(")");
            f(left, right + 1, n, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}

