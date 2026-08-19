class Solution {
    public String largestGoodInteger(String num) {
        int[] nums = new int[num.length()];
        for(int i = 0; i < nums.length; i++) {
            nums[i] = num.charAt(i) - '0';
        }
        int max = -1;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] == nums[i - 1] && nums[i] == nums[i - 2]) {
                int number = nums[i] * 100 + nums[i] * 10 + nums[i];
                max = Math.max(max, number);
            }
        }

        if(max == -1) return "";
        if(max == 0) return "000";
        
        return String.valueOf(max);
    }
}