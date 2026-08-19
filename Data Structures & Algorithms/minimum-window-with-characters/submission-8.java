class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int[] need = new int[128];
        int[] window = new int[128];
        int l = 0, r = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        for(char c: t.toCharArray()) {
            need[c]++;
        }
        while(r < s.length()) {
            char c = s.charAt(r++);
            window[c]++;
            while(f(need, window)) {
                if(r - l < len) {
                    start = l;
                    len = r - l;
                }
                char d = s.charAt(l++);
                window[d]--;
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    boolean f(int[] need, int[] window) {
        for(int i = 0; i < 128; i++) {
            if(window[i] < need[i]) return false;
        }
        return true;
    }
}
