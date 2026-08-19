class Solution {

    List<List<Integer>> res = new LinkedList<>();
    List<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        f(nums, target, 0);
        return res;
    }

    void f(int[] nums, int target, int start) {
        if(target == 0) {
            res.add(new LinkedList<>(list));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            f(nums, target - nums[i], i);
            list.remove(list.size() - 1);
        }
    }
}
