class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums) {
            map.putIfAbsent(n, 0);
            map.put(n, map.get(n) + 1);
        }
        for(int v: map.values()) {
            if(v % 2 != 0) return false;
        }
        return true;
    }
}