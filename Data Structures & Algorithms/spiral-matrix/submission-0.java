class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int leftBoundary = 0;
        int rightBoundary = matrix[0].length - 1;
        int upBoundary = 0;
        int downBoundary = matrix.length - 1;


        while(leftBoundary <= rightBoundary && upBoundary <= downBoundary) {
            // upper
            for(int i = leftBoundary; i <= rightBoundary; i++) {
                res.add(matrix[upBoundary][i]);
            }
            upBoundary++;
            // right
            for(int i = upBoundary; i <= downBoundary; i++) {
                res.add(matrix[i][rightBoundary]);
            }
            rightBoundary--;
            // down
            if(upBoundary <= downBoundary) {
                for(int i = rightBoundary; i >= leftBoundary; i--) {
                res.add(matrix[downBoundary][i]);
                }
            }
            downBoundary--;
            // left
            if(leftBoundary <= rightBoundary) {
                for(int i = downBoundary; i >= upBoundary; i--) {
                    res.add(matrix[i][leftBoundary]);
                } 
            }
            leftBoundary++;
        }

        return res;
        
        
       
    }
}
