class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int need = tickets[k];
        int n = tickets.length;
        int time = n * need;
        for(int i = 0; i < n; i++) {
            if(tickets[i] < need) {
                time -= need - tickets[i];
            }
            if(i > k && tickets[i] >= need) {
                time -= 1;
            } 
        }

        
        
        return time;
    }
}