class Solution {
    boolean[] memo = new boolean[244];
    public boolean isHappy(int n) {
        if(n == 1) return true;
        int nn = 0;
        while(n != 0) {
            nn += (n % 10) * (n % 10);
            n /= 10;
        }
        if(memo[nn]) return false;
        memo[nn] = true;

        
        return isHappy(nn);

    }

}
