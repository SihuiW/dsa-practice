class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        f(nums, 0, new ArrayList<>());
        return list;
    }

    void f(int[] nums, int start, List<Integer> temp) {
        list.add(new ArrayList<>(temp));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            f(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}