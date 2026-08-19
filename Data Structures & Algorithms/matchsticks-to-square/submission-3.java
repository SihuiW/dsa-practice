class Solution {

    boolean[] used;

    public boolean makesquare(int[] matchsticks) {
        int total = 0;
        for (int m : matchsticks) {
            total += m;
        }
        if (total % 4 != 0) return false;
        int length = total / 4;

        Arrays.sort(matchsticks);
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        for (int m : matchsticks) {
            if (m > length) return false;
        }

        used = new boolean[matchsticks.length];
        return f(matchsticks, 0, 4, length, 0);
    }

    boolean f(int[] matchsticks, int start, int remain, int length, int sum) {
        if (remain == 0) return true;
        if (sum == length) return f(matchsticks, 0, remain - 1, length, 0);

        for (int i = start; i < matchsticks.length; i++) {
            if (used[i]) continue;

            //if (i > 0 && matchsticks[i] == matchsticks[i - 1] && !used[i - 1]) continue;

            if (sum + matchsticks[i] > length) continue;

            used[i] = true;

            if (f(matchsticks, i + 1, remain, length, sum + matchsticks[i])) {
                return true;
            }

            used[i] = false;
        }

        return false;
    }
}
