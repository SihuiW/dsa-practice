class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(map.containsKey(key)) {
                map.get(key).add(s);
            } else {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(key, temp);
            }
        }

        for(List<String> list: map.values()) {
            res.add(list);
        } 
        return res;

    }
}
