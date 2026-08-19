class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefix = 0;
        map.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int remain = prefix % k;
            if(map.containsKey(remain)){
                if(i - map.get(remain) >= 2) return true;
            } else {
                map.put(remain, i);
            }

        }
        return false;
    }
}