class Solution {
    public int maxDifference(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        int cnt = 0;
        for(int i = 0; i <= cs.length; i++) {
            if(i < cs.length && (i == 0 || cs[i] == cs[i-1])) {
                cnt++;
            } else {
                if(cnt % 2 == 0) {
                    minEven = Math.min(cnt, minEven);
                } else {
                    maxOdd = Math.max(cnt, maxOdd);
                }
                cnt = 1;
            }
        }
        return maxOdd - minEven;
    }
}