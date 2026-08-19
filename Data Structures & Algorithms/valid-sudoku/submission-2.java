class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<Integer>> rows = new HashMap<>();
        Map<Integer, List<Integer>> cols = new HashMap<>();
        Map<Integer, List<Integer>> box = new HashMap<>();
        for(int i = 0; i < 9; i++) {
            rows.put(i, new ArrayList<>());
            cols.put(i, new ArrayList<>());
            box.put(i, new ArrayList<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') continue;
                int n = board[i][j] - '0';

                int idx = (i / 3) * 3 + (j / 3);
                if(rows.get(i).contains(n) || cols.get(j).contains(n) || box.get(idx).contains(n)) return false;
                rows.get(i).add(n);
                cols.get(j).add(n);
                box.get(idx).add(n);
            }
        }
        return true;
    }
}
