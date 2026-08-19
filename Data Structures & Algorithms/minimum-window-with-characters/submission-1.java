class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        Map<Character, Integer> window = new LinkedHashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        int min = s.length() + 1;
        int start = 0;
        for(char c: t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c,0) + 1);
        }
        int l = 0, r = 0;
        int valid = 0;
        while(r < s.length()) {
            char c = s.charAt(r);
            r++;
            window.put(c, window.getOrDefault(c, 0) + 1);
            if(tmap.containsKey(c) && window.get(c) == tmap.get(c)) {
                valid++;
            }
            while(valid == tmap.size()) {
                int len = r - l;
                min = Math.min(min, len);
                if(min == len) start = l;
                char d = s.charAt(l);
                if(tmap.containsKey(d) && tmap.get(d) == window.get(d)) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
                l++;
               
            }           
        }
        return min == s.length() + 1 ? "" : s.substring(start,start+min);
    }
}

