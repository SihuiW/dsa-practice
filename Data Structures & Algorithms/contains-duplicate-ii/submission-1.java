class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if(j != i && Math.abs(i - j) <= k) return true;
            }
            
        }
        return false;
    }
}