class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        f(nums, 0, new ArrayList<>());
        int sum = 0;
        for(List<Integer> l: res) {
            int temp = 0;
            for(int e: l) {
                temp ^= e;
            }
            sum += temp;
        }

        return sum;
    }

    void f(int[] nums, int idx, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            f(nums, i + 1, list);
            list.remove(list.size() - 1);
        }

    }


}