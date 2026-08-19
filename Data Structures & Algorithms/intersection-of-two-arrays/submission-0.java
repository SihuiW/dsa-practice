class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> collect = new HashSet<>();
        Set<Integer> n2 = new HashSet<>();
        for(int n: nums2) n2.add(n);
        for(int n: nums1) {
            if(n2.contains(n)) collect.add(n);
        }
        int[] res = new int[collect.size()];
        int i = 0;
        for(int n : collect) {
            res[i++] = n;
        }
        return res;
    }
}