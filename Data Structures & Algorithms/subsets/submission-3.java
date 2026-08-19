class Solution {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        f(nums, 0, new ArrayList<>());
        return list;
    }

    void f(int[] nums, int idx, List<Integer> temp) {
        if(idx == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        };
        f(nums, idx + 1, temp);
        temp.add(nums[idx]);
        f(nums, idx + 1, temp);
        temp.remove(temp.size() - 1);
    }
}
