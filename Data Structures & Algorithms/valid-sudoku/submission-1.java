class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> rows = new HashMap<>();
        HashMap<Integer, Set<Character>> cols = new HashMap<>();
        HashMap<Integer, Set<Character>> boxes = new HashMap<>();

        for(int i = 0; i < 9; i++) {
            rows.put(i, new HashSet<>());
            cols.put(i, new HashSet<>());
            boxes.put(i, new HashSet<>());
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                char num = board[i][j];
                if(num == '.') continue;
                if(rows.get(i).contains(num)) return false;
                if(cols.get(j).contains(num)) return false;
                if(boxes.get((i/3) * 3 + j / 3).contains(num)) return false;

                rows.get(i).add(num);
                cols.get(j).add(num);
                boxes.get((i/3) * 3 + j/3).add(num);
            }
        }
        return true;

    }
}
