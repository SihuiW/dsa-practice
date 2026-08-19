class Solution {
    public int findLonelyPixel(char[][] picture) {
        int[] rowCount = new int[picture.length];
        int[] colCount = new int[picture[0].length];
        int m = picture.length;
        int n = picture[0].length;
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B') {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                    res++;
                }
            }
        }
        return res;

    }
}