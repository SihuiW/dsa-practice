class Solution {
    public int[][] candyCrush(int[][] board) {
        while (mark(board)) {
            drop(board);
        }
        return board;
    }

    private boolean mark(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean isMarked = false;

        for (int i = 0; i < m; i++) {
            int count = 1;

            for (int j = 1; j <= n; j++) {
                if (j < n
                        && board[i][j] != 0
                        && Math.abs(board[i][j]) == Math.abs(board[i][j - 1])) {
                    count++;
                } else {
                    if (count >= 3 && board[i][j - 1] != 0) {
                        for (int k = j - count; k < j; k++) {
                            board[i][k] = -Math.abs(board[i][k]);
                        }
                        isMarked = true;
                    }

                    count = 1;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            int count = 1;

            for (int i = 1; i <= m; i++) {
                if (i < m
                        && board[i][j] != 0
                        && Math.abs(board[i][j]) == Math.abs(board[i - 1][j])) {
                    count++;
                } else {
                    if (count >= 3 && board[i - 1][j] != 0) {
                        for (int k = i - count; k < i; k++) {
                            board[k][j] = -Math.abs(board[k][j]);
                        }
                        isMarked = true;
                    }

                    count = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }

        return isMarked;
    }

    private void drop(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int j = 0; j < n; j++) {
            int write = m - 1;

            for (int read = m - 1; read >= 0; read--) {
                if (board[read][j] != 0) {
                    board[write][j] = board[read][j];
                    write--;
                }
            }

            while (write >= 0) {
                board[write][j] = 0;
                write--;
            }
        }
    }
}