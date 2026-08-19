class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i <= n * n; i++) {
            map.put(i, 0);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                map.put(grid[i][j], map.get(grid[i][j]) + 1);
            }
        }
        int[] res = new int[2];
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 2) {
                res[0] = entry.getKey();
            }
            if(entry.getValue() == 0) {
                res[1] = entry.getKey();
            }
        }
        return res;
    }
}