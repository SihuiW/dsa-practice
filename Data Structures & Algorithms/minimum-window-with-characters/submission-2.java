class Solution {
    public String minWindow(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int[] cnts = new int[256];
        for(char c: tt) {
            cnts[c]--;
        }
        int len = Integer.MAX_VALUE;
        int start = 0;
        int debt = tt.length;
        for(int l = 0, r = 0; r < ss.length; r++) {
            if(cnts[ss[r]]++ < 0) {
                debt--;
            }
            if(debt == 0) {
                while(cnts[ss[l]] > 0) {
                    cnts[ss[l++]]--;
                }
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
