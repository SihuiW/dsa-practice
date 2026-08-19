class Solution {
    public int scoreOfString(String s) {
        int res = 0;
        int a = (int)s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            res += Math.abs((int)s.charAt(i) - a);
            a = (int)s.charAt(i);
        }
        return res;
    }
}