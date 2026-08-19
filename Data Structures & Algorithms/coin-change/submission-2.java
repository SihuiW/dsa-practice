class Solution {
    // 找到金额等于amount时需要的最少的硬币数量
    // 第一次拿coins[i] 之后就是amount - coins[i]的金额
    // 直到amount == 0 return 个数
    // 如果amount < 0 return -1

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return f(coins, amount, memo);
    }

    int f(int[] coins, int amount, int[] memo) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != -2) return memo[amount];
        int times = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int sub = f(coins, amount - coins[i],memo);
            if(sub >= 0) {
                times = Math.min(times, sub + 1);
            }
        }
        memo[amount] = (times == Integer.MAX_VALUE) ? -1 : times;

        return memo[amount];
    }

}
