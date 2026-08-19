class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new LinkedList<>();
        for(String str: strs) {
            int[] nums = new int[26];
            String count = stringToNum(str,nums);
            if(!map.containsKey(count)) {
                map.put(count, new LinkedList<>());
            }
            map.get(count).add(str);

            
        }
        for(List<String> list: map.values()) {
            res.add(list);
        }
        return res;
    }

    private String stringToNum(String str, int[] nums) { 
       for(char c: str.toCharArray()) {
        nums[c - 'a']++;
       }
       return Arrays.toString(nums);
    }
}
