class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] need = new int[128];
        int[] window = new int[128];
        int l = 0, r = 0;
        int start = 0;
        int miss = t.length();
        int len = Integer.MAX_VALUE;
        for(char c: t.toCharArray()) {
            need[c]++;
        }
        while(r < s.length()) {
            char c = s.charAt(r++);
            window[c]++;
            if(window[c] <= need[c]) {
                miss--;
            }
            while(miss == 0) {
                if(r - l < len) {
                    len = r - l;
                    start = l;
                }
                char d = s.charAt(l++);
                if(window[d] <= need[d]) {
                    miss++;
                }
                window[d]--;
            }

            
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    
}