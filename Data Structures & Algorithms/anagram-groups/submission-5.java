class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
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

        return new ArrayList<>(map.values());

    }
}
