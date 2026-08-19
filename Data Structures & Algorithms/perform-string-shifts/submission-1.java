class Solution {
    public String stringShift(String s, int[][] shift) {
        int move = 0;

        for (int[] sh : shift) {
            int direction = sh[0];
            int amount = sh[1];

            if (direction == 0) {
                move -= amount; // 左移
            } else {
                move += amount; // 右移
            }
        }

        int n = s.length();

        // 把最终移动量转换成 0 到 n - 1 之间的右移次数
        move = ((move % n) + n) % n;

        if (move == 0) {
            return s;
        }

        return s.substring(n - move) + s.substring(0, n - move);
    }
}