class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        f(nums, new ArrayList<>(), visited);
        return res;
    }

    void f(int[] nums, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            list.add(nums[i]);
            visited[i] = true;
            f(nums, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
