class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        f(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    void f(int[] candidates, int target, List<Integer> list, int idx) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            if(candidates[i] > target) return;
            list.add(candidates[i]);
            f(candidates, target - candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

