class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int[] arr = new int[m*n];
        int index = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[index++] = matrix[i][j];
            }
        }
        int l = 0, r = arr.length - 1;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) {
                return true;
            } else if(arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
