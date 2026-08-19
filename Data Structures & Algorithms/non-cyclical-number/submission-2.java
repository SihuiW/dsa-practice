class Solution {
    Set<Integer> memo = new HashSet<>();
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int num = helper(n);
        if(memo.contains(num)) return false;
        memo.add(num);
        return isHappy(num);
    }

    int helper(int n) {
        int res = 0;
        while(n != 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        return res;
    }

}
