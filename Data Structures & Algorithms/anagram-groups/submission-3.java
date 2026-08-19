class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            int[] nums = new int[26];
            for(char c: str.toCharArray()) {
                nums[c - 'a']++;
            }
            String keys = Arrays.toString(nums);
            if(!map.containsKey(keys)) {
                map.put(keys, new LinkedList<>());
            }
            map.get(keys).add(str);
        } 
        return new ArrayList<>(map.values());
    }

}
