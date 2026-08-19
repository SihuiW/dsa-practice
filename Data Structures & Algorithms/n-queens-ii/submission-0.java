class Solution {

    int res = 0;

    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> sideDiag = new HashSet<>();

        f(board, 0, cols, diag, sideDiag);
        return res;
    }

    void f(int[][] board, int i, Set<Integer> cols, Set<Integer> diag, Set<Integer> sideDiag) {
        if(i == board.length) {
            res++;
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if(cols.contains(j) || diag.contains(i - j) || sideDiag.contains(i + j)) continue;
            cols.add(j);
            diag.add(i - j);
            sideDiag.add(i + j);
            f(board, i + 1, cols, diag, sideDiag);
            cols.remove(j);
            diag.remove(i - j);
            sideDiag.remove(i + j);
        }
    }
}