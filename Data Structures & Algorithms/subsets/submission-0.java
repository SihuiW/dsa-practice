class Solution {
    // 用回溯，有一个全局变量res负责收集,单个变量list收集路线上的结果
    // 回溯return是index到末尾就返回 f(int[] nums, List<Integer> list, int index)
    // for循环从第一个开始，把自己加入这一层的list 然后list加入res
    // 接着传list index++到下一个

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        f(nums, new ArrayList<>(), 0);
        return res;
    }

    void f(int[] nums, List<Integer> list, int index) {
        res.add(new ArrayList<>(list));

        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            f(nums, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
