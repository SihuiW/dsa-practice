class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for(int[] row: matrix) {
            swap(row);
        }
        for(int i = 0; i < m - 1; i++) {
            for(int j = 0; j < m - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][m - i - 1];
                matrix[m - j - 1][m - i - 1] = temp;
            }
        }
        
    }

    void swap(int[] row) {
        int l = 0, r = row.length - 1;
        while(l <= r) {
            int temp = row[l];
            row[l] = row[r];
            row[r] = temp;
            r--;
            l++;
        }
    }
}
