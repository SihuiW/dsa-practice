class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        f(nums, target, new ArrayList<>(), 0, 0);
        return res;
    }

    void f(int[] nums, int target, List<Integer> temp, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (sum + nums[i] > target) break;

            temp.add(nums[i]);

            f(nums, target, temp, sum + nums[i], i);

            temp.remove(temp.size() - 1);
        }
    }
}