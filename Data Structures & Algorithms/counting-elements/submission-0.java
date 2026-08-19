class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for(int n: arr) set.add(n);
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i] + 1)) res++;
        }
        return res;
    }
}
