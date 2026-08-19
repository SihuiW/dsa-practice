class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        f(nums, new ArrayList<>(), 0);
        return res;
    }

    void f(int[] nums, ArrayList<Integer> list, int index) {
        res.add(new ArrayList<>(list)); 

        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            f(nums,list,i+1);
            list.remove(list.size() - 1);
        }
    }
}
