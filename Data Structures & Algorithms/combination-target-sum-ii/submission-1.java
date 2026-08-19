class Solution {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        f(candidates, target, new ArrayList<>(), 0);
        return res;
        
    }

    void f(int[] candidates, int target, ArrayList<Integer> list, int index) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            target -= candidates[i];
            list.add(candidates[i]);
            f(candidates, target, list, i + 1);
            target += candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
