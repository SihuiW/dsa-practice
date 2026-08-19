class Solution {
    public int arrangeCoins(int n) {
        int coin = n;
        int row = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                coin--;
            }
            if(coin < 0) break;
            row++;
        }
        return row;
    }
}