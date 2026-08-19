class Solution {

    boolean[] used;

    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int m : matchsticks) {
            total += m;
        }
        if (total % 4 != 0) return false; // 如果总长度不能被4整除，立刻返回false

        int length = total / 4;

        // 火柴排序：降序排列，剪枝性能更好
        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        // 如果有任何一根火柴大于单侧长度，立刻返回false
        for (int m : matchsticks) {
            if (m > length) return false;
        }

        used = new boolean[matchsticks.length];
        return f(matchsticks, 0, 4, length, 0);
    }

    boolean f(int[] matchsticks, int start, int remain, int length, int sum) {
        if (remain == 0) return true; // 说明成功拼成4条边
        if (sum == length) return f(matchsticks, 0, remain - 1, length, 0); // 当前一条边拼成，开始下一条

        for (int i = start; i < matchsticks.length; i++) {
            if (used[i]) continue;

            // 剪枝条件1：跳过重复火柴（保证同一层的剪枝）
            if (i > 0 && matchsticks[i] == matchsticks[i - 1] && !used[i - 1]) continue;

            // 如果火柴加上去当前边会超出规定长度，直接剪枝
            if (sum + matchsticks[i] > length) continue;

            // 选择当前火柴
            used[i] = true;

            // 递归进入下一层决策
            if (f(matchsticks, i + 1, remain, length, sum + matchsticks[i])) {
                return true; // 如果后续可以成功，就直接返回
            }

            // 回溯：撤销选择
            used[i] = false;
        }

        return false; // 如果所有情况都无法拼成，返回false
    }
}
