class Solution {
    
    List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(nums, 0, target, 0, new ArrayList<>());
        return res;
    }

    void dfs(int[] nums, int idx, int target, int sum, ArrayList<Integer> list) {
        if(sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        if(sum > target) return;

        for(int i = idx; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            sum += nums[i];
            list.add(nums[i]);
            dfs(nums, i, target, sum, list);
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
    }


}
