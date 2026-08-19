class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int p1 = 0, p2 = people.length - 1;
        int res = 0;
        while(p1 <= p2) {
            int sum = people[p1] + people[p2];
            if(sum <= limit) {
                p1++;
                p2--;
                res++;
            } else {
                if(p1 == p2) {
                    res++;
                    return res;
                }
                res++;
                p2--;
            }
        }
        return res;
    }

    
}