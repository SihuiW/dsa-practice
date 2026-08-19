class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        int start = image[sr][sc];
        if (start == color) return image;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if(image[cur[0]][cur[1]] == start) {
                image[cur[0]][cur[1]] = color;
                for(int[] d: dir) {
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];
                    if(nr < 0 || nc < 0 || nr >= image.length || nc >= image[0].length) continue;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
}