class Solution {
    // f()定义：到ij这个点有几种方式
    public int uniquePaths(int m, int n) {
        f(m - 1, n - 1);
        return res;
    }
    int res = 0;
    void f(int i, int j) {
        if(i < 0 || j < 0) return;
        if(i == 0 && j == 0) {
            res++;
        }
        f(i - 1, j);
        f(i, j - 1);
    }
}
