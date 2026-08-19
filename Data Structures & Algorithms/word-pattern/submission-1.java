class Solution {
    public boolean wordPattern(String pattern, String s) {
        char[] p = pattern.toCharArray();
        String[] ss = s.split(" ");
        if(p.length != ss.length) return false;
        Map<String, Character> map1 = new HashMap<>();
        Map<Character, String> map2 = new HashMap<>();
        for(int i = 0; i < ss.length; i++) {
            if(map1.containsKey(ss[i]) || map2.containsKey(p[i])) {
                if (!ss[i].equals(map2.get(p[i])) || !map1.get(ss[i]).equals(p[i])) return false;
            } else {
                map1.put(ss[i], p[i]);
                map2.put(p[i], ss[i]);
            }
        }
        return true;

    }
}