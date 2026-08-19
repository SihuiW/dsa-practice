class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        f(n, 1, k, new ArrayList<>());
        return res;
    }

    void f(int n, int start, int k, List<Integer> temp) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i <= n; i++) {
            temp.add(i);
            f(n, i + 1, k, temp);
            temp.remove(temp.size() - 1);
        }
    }
}