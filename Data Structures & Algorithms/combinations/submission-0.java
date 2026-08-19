class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        f(n,0,k,new ArrayList<>());
        return res;
    }

    void f(int n, int index, int k, List<Integer> list) {
        if(list.size() == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(index >= n) {
            return;
        }
        for(int i = index; i < n; i++) {
            list.add(i + 1);
            f(n, i + 1, k, list);
            list.remove(list.size() - 1);
        }

    }
}