// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSortHelper(pairs, 0, pairs.size() - 1);
    }

    public List<Pair> mergeSortHelper(List<Pair> pairs, int i, int j) {
        if(j - i  + 1 <= 1) return pairs;

        int m = (i + j) / 2;

        mergeSortHelper(pairs, i, m);
        mergeSortHelper(pairs, m + 1, j);

        merge(pairs, i, m, j);

        return pairs;

    }

    public void merge(List<Pair> list, int i, int m, int j) {
        List<Pair> L = new ArrayList<>(list.subList(i, m + 1));
        List<Pair> R = new ArrayList<>(list.subList(m + 1, j + 1));

        int p1 = 0, p2 = 0, p3 = i;

        while (p1 < L.size() && p2 < R.size()) {
            if (L.get(p1).key <= R.get(p2).key) {
                list.set(p3, L.get(p1));
                p1++;
            } else {
                list.set(p3, R.get(p2));
                p2++;
            }
            p3++;
        }

        while (p1 < L.size()) {
           list.set(p3, L.get(p1));
           p1++;
           p3++;
        }
        while (p2 < R.size()) {
           list.set(p3, R.get(p2));
           p2++;
           p3++;
        }
    }
}


