class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for(char c: t.toCharArray()) {
            map[c]--;
        }
        int need = t.length();
        int l = 0, r = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while(r < s.length()) {
            if(map[s.charAt(r)] < 0) {
                need--;
            }
            map[s.charAt(r)]++;
            while(need == 0) {
                if(r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
                map[s.charAt(l)]--;
                if(map[s.charAt(l)] < 0) {
                    need++;
                }
                l++;

            }
            r++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);

    }

}