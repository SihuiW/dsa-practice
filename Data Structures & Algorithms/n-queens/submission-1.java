class Solution {
    List<List<String>> res = new ArrayList<>();
    boolean[] cols;
    boolean[] diag1;
    boolean[] diag2;
    public List<List<String>> solveNQueens(int n) {
        cols = new boolean[n];
        diag1 = new boolean[2 * n];
        diag2 = new boolean[2 * n];
        char[][] map = new char[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], '.');
        }
        f(map, 0);
        return res;
    }

    void f(char[][] map, int row) {
        if(row == map.length) {
            List<String> r = print(map);
            res.add(r);
            return;
        }
        for(int j = 0; j < map[0].length; j++) {
            if(cols[j] || diag1[row - j + map.length] || diag2[j + row]) continue;
            map[row][j] = 'Q';
            cols[j] = true;
            diag1[row - j + map.length] = true;
            diag2[j + row] = true;
            f(map, row + 1);
            map[row][j] = '.';
            cols[j] = false;
            diag1[row - j + map.length] = false;
            diag2[j + row] = false;
        }
    }

    List<String> print(char[][] map) {
        List<String> res = new ArrayList<>();
        for(char[] m: map) {
            StringBuilder sb = new StringBuilder();
            for(char c: m) {
                sb.append(c);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
