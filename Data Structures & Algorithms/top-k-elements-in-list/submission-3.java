class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int n: map.keySet()) {
            buckets[map.get(n)].add(n);
        }
        int[] res = new int[k];
        int idx = buckets.length - 1;
        for(int i = 0; i < k;) {
            while(idx >= 0 && buckets[idx].size() == 0) {
                idx--;
            }
            for(int e: buckets[idx]) {
                if (i < k) {
                    res[i] = e;
                    i++;
                }
            }
            idx--;
        }
        return res;
    }
}
