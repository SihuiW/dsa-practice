class Solution {

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> list = new LinkedList<>();
        backtrack(0,nums,list,target);
        return res;
    }

    void backtrack(int start, int[] nums, List list, int target) {
        if(target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if(target < 0) {
            return;
        }
        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backtrack(i, nums, list, target - nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
