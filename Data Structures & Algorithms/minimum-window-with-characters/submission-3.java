class Solution {
    public String minWindow(String s, String t) {
        int[] window = new int[128];
        int debt = t.length();
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++) {
            window[t.charAt(i)]--;
        }
        int l = 0, r = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            if(window[c] < 0) {
                debt--;
            }
            window[c]++;
            
            while(debt == 0) {
                int tempLen = r - l + 1;
                if(tempLen < len) {
                    len = tempLen;
                    start = l;
                }
                
                char d = s.charAt(l);
                window[d]--;
                if(window[d] < 0) {
                    debt++;
                }
                l++;
            }
            r++;
        }

        return len == Integer.MAX_VALUE? "": s.substring(start, start + len);
    }
}