class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        f(n, k, 1, new ArrayList<>());
        return res;
    }

    void f(int n, int k, int idx, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = idx; i <= n; i++) {
            list.add(i);
            f(n, k, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}