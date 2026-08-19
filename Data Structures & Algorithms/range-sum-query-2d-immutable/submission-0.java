class NumMatrix {
    private int[][] prefix;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        prefix = new int[m + 1][n + 1];

        // 统一填充所有位置（包括第一行第一列）
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = prefix[i-1][j] 
                             + prefix[i][j-1] 
                             - prefix[i-1][j-1] 
                             + matrix[i-1][j-1];  // 关键：不能遗漏
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
             - prefix[row2 + 1][col1]
             - prefix[row1][col2 + 1]
             + prefix[row1][col1];
    }
}