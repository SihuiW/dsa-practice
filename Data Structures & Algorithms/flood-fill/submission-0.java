class Solution {
    int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldC = image[sr][sc];
        if(oldC == color) return image;
        f(image, sr, sc, oldC, color);
        return image;
    }

    void f(int[][] image, int i, int j, int oldC, int newC) {
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != oldC) return;
        image[i][j] = newC;
        for(int[] d: dir) {
            f(image, i + d[0], j + d[1], oldC, newC);
        }
    }
}