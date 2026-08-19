class Solution {
    public boolean check(int[] nums) {
        int[] circle = new int[2 * nums.length];
        for(int i = 0; i < circle.length; i++) {
            circle[i] = nums[i % nums.length];
        }

        int window = 1;

        for(int i = 1; i < circle.length; i++) {
            if(circle[i - 1] <= circle[i]) {
                window++;
                if(window == nums.length) return true;
            } else {
                window = 1;
            }
        }
        return false;
    }
}