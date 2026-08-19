public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
        int n = pairs.size();
        List<List<Pair>> res = new ArrayList<>();
        if (n == 0) return res;

        for (int i = 0; i < n; i++) {
            int j = i - 1;
            while (j >= 0 && pairs.get(j).key > pairs.get(j + 1).key) {
                swap(pairs, j, j + 1);
                j--;
            }
            res.add(new ArrayList<>(pairs));
        }

        return res;
    }

    void swap(List<Pair> p, int i, int j) {
        Pair temp = p.get(i);
        p.set(i, p.get(j));
        p.set(j, temp);
    }
}