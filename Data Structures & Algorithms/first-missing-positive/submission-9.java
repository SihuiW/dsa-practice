class Solution {
    public int firstMissingPositive(int[] nums) {
        int first = 1;
        Set<Integer> set = new HashSet<>();
        for(int n: nums) set.add(n);
        while(true) {
            if(set.contains(first)) {
                first++;
            } else {
                return first;
            }
        }
    }
}