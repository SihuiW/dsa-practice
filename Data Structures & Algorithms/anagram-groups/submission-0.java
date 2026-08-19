class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        for(String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String ns = new String(c);
            map.put(ns, new LinkedList<>());
        }
        for(String str: strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String ns = new String(c);
            if(map.containsKey(ns)) {
                map.get(ns).add(str);
            }
        }
        for(List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }
}
