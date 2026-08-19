class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int res = 0;
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        while(l <= r) {
            if(l == r) return res + 1;
            int sum = people[l] + people[r];
            if(sum <= limit) {
                res++;
                l++;
                r--;
            } else {
                if(people[l] >= limit) {
                    res++;
                    l++;
                } else if(people[r] >= limit) {
                    res++;
                    r--;
                } else {
                    res++;
                    r--;
                }
            }
        }
        return res;
    }
}
