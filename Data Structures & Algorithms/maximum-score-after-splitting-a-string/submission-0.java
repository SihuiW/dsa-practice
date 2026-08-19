class Solution {
    public int maxScore(String s) {
        int res = 0;
        for(int i = 1; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i, s.length());
            int score = f(left, right);
            res = Math.max(res, score);
        } 
        return res;
    }

    int f(String left, String right) {
        int res = 0;
        char[] l = left.toCharArray();
        char[] r = right.toCharArray();
        for(int i = 0; i < l.length; i++) {
            if(l[i] == '0') res++;
        }
        for(int i = 0; i < r.length; i++) {
            if(r[i] == '1') res++;
        }
        return res;
    }
}