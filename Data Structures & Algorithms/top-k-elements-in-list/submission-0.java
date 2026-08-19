class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        while(k > 0) {
            list.add(findFrequent(map));
            k--;
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
        
    }

    private int findFrequent(Map<Integer, Integer> map) {
        int max = 0;
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
          int times = entry.getValue();
          int num = entry.getKey();
          max = Math.max(max, times);
          if(max == times) {
            res = num;
          }
        }
        map.remove(res);
        return res;
        
    }
}
