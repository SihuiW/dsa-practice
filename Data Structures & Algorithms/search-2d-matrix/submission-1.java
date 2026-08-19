class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = n * m - 1;
        while(l <= r) {
            int mIndex = l + (r - l) / 2;
            int mid = getMid(matrix, mIndex);
            if(mid == target) {
                return true;
            } else if(mid < target) {
                l = mIndex + 1;
            } else {
                r = mIndex - 1;
            }

        }
        return false;
    }

    int getMid(int[][] matrix, int index) {
        int n = matrix[0].length;
        int i = index / n;
        int j = index % n;
        return matrix[i][j];
    }
}
