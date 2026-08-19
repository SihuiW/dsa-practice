class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        quickSortHelper(pairs, 0, pairs.size() - 1);
        return pairs;
    }
    
    private void quickSortHelper(List<Pair> pairs, int left, int right) {
        if (left >= right) {
            return;
        }
        
        Pair pivot = pairs.get(right);
        int i = left - 1;
        
        // 把小于 pivot 的元素移到左边
        for (int j = left; j < right; j++) {
            if (pairs.get(j).key < pivot.key) {
                i++;
                swap(pairs, i, j);
            }
        }
        
        swap(pairs, i + 1, right);
        
        int pivotIndex = i + 1;
        
        quickSortHelper(pairs, left, pivotIndex - 1);
        quickSortHelper(pairs, pivotIndex + 1, right);
    }
    
    private void swap(List<Pair> pairs, int a, int b) {
        Pair temp = pairs.get(a);
        pairs.set(a, pairs.get(b));
        pairs.set(b, temp);
    }
}