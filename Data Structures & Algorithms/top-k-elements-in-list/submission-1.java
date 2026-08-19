class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer>[] list = new List[nums.length+1];
        for(int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            list[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for(int i = list.length - 1; i >= 0; i--) {
            List<Integer> sublist = list[i];
            if(!sublist.isEmpty()) {
                for(int j = 0; j < sublist.size() && index < k; j++) {
                    res[index++] = sublist.get(j);
                }
            }
            
        }
        return res;

        
    }

   
}
