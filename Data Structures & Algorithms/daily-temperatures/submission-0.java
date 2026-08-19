class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        if(n == 1) {
            res[0] = 0;
            return res;
        }
        for(int i = 0; i < n; i++) {
            int days = 0;
            int curTem = temperatures[i];
            int j = i + 1;
            while(j < n) {
                int aftTem = temperatures[j];
                if(aftTem > curTem) {
                    res[i] = days + 1;
                    break;
                }
                j++;
                days++;
            }
        }
        return res;
    }


}
