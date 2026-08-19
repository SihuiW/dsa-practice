class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        int res = 0;
        for(int v: map.values()) {
            res += v * (v - 1) / 2;
        }
        return res;
    }
}