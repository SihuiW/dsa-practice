class Solution {

    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        f(nums, 0, new ArrayList<>());
        return list;
    }

    void f(int[] nums, int idx, List<Integer> temp) {
        list.add(new ArrayList<>(temp));
        for(int i = idx; i < nums.length; i++) {
            temp.add(nums[i]);
            f(nums, i + 1, temp);
            temp.remove(temp.size() - 1);
        }

    }
}
