class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int can1 = 0, can2 = 0, count1 = 0, count2 = 0;
        for(int n: nums) {
            if(n == can1) {
                count1++;
            } else if (n == can2) {
                count2++;
            } else if(count1 == 0) {
                can1 = n;
                count1++;
            } else if(count2 == 0) {
                can2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        int times = nums.length / 3;
        count1 = 0;
        count2 = 0;
        for(int n: nums) {
            if(n == can1) {
                count1++;
            } else if(n == can2) {
                count2++;
            }
        }
        if(count1 > times) res.add(can1);
        if(count2 > times && can1 != can2) res.add(can2);
        return res;
    }
}