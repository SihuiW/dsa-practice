class Solution {
    // 要三个set去重行列9宫格

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<Integer, Set<Character>> box = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            row.put(i, new HashSet<>());
            col.put(i, new HashSet<>());
            box.put(i, new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') {
                    continue;
                }
                if(row.get(i).contains(c) || col.get(j).contains(c) || box.get((i / 3) * 3 + j / 3).contains(c)) {
                    return false;
                }
                row.get(i).add(c);
                col.get(j).add(c);
                box.get((i / 3) * 3 + j / 3).add(c);
            }
        }
        return true;
    }
}
